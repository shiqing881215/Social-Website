package controller.facebook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.User;

import controller.Action;
import databean.FacebookUser;

/**
 * Action for facebook search
 * 
 * @author shiqing
 *
 */
public class FacebookSearchAction extends Action {
	public FacebookSearchAction(Model model){}

	@Override
	public String getActionName() {
		return "fb_FacebookSearch.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		FacebookClient facebookClient = (FacebookClient) request.getSession().getAttribute("facebookClient");
		String query = request.getParameter("facebookUser");
		// The result of this search call just contains the id of user, so we need to do another api call to fetch the object
		Connection<User> fbUsers = 
				facebookClient.fetchConnection("search", User.class, Parameter.with("q", query), Parameter.with("type", "user"));
		List<FacebookUser> users = FacebookUtil.get().fetchUserInfoFromIds(facebookClient, fbUsers, FacebookUtil.SEARCH_SIZE);
        request.setAttribute("fbUserSearchList", users);
        
		return "view/facebook/FacebookSearch.jsp";
	}
}
