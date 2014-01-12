package controller.instagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import model.Model;

import com.sola.instagram.exception.InstagramException;
import com.sola.instagram.io.GetMethod;
import com.sola.instagram.io.UriFactory;
import com.sola.instagram.model.Media;
import com.sola.instagram.model.User;
import com.sola.instagram.util.PaginatedCollection;
import com.sola.instagram.util.UriConstructor;

import configuration.SessionUserAttribute;
import controller.Action;
import databean.instagram.InstagramClient;

/**
 * Get Instagram login user profile and home feeds.
 * 
 * @author shiqing
 *
 */
public class InstagramHomeAction extends Action {
	public InstagramHomeAction(Model model){}

	@Override
	public String getActionName() {
		return "ins_InstagramHome.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		InstagramClient instagramClient = (InstagramClient) request.getSession().getAttribute(SessionUserAttribute.INSTAGRAM_USER.getValue());
		if (instagramClient == null) {
			return "/view/instagram/InstagramLogin.jsp";
		} 
		try {
			// Get login user home feeds list
			PaginatedCollection<Media> feeds = instagramClient.getInstagramSession().getFeed();
			List<Media> feedsList = listifyFeeds(feeds);
			request.setAttribute("feedsList", feedsList);
			
			// Get login user profile
			User instagramLoginUser = getUserById("self", instagramClient);
			request.setAttribute("loginUser", instagramLoginUser);
			
			return "/view/instagram/InstagramHome.jsp";
		} catch (Exception e) {
			// TODO Log
			return "/view/error.jsp";
		}
	}

	/**
	 * Use util.list to hold all feeds instead of PaginatedCollection, so jsp knows how to use it
	 * @param feeds
	 * @return
	 */
	private List<Media> listifyFeeds(PaginatedCollection<Media> feeds) {
		List<Media> feedsList = new ArrayList<Media>();
		for (int i =0; i < feeds.size(); i++) {
			feedsList.add(feeds.get(i));
		}
		return feedsList;
	}
	
	/**
	 * InstagramSession getUserById is not support for "self" attribute 
	 * Rewrite to support https://api.instagram.com/v1/users/self
	 * @param userId - Can be id of user or "self" for login user
	 * @return
	 * @throws Exception
	 */
	private User getUserById(String userId, InstagramClient client) throws Exception {
		UriConstructor uriConstructor = new UriConstructor(client.getAccessToken());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", userId);
		String uri = uriConstructor.constructUri(UriFactory.Users.GET_DATA, map, true);
		JSONObject userObject = (new GetMethod(uri).call()).getJSON();
		if (userObject.has("data")) {
			return new User(userObject.getJSONObject("data"), client.getAccessToken());
		} else {
			throw new InstagramException("User with id = " + userId
					+ " cannot be accessed" + " or may not exist");
		}
	}
	
}
