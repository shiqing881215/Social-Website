package controller.facebook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.types.Post;
import com.restfb.types.User;

import configuration.SessionUserAttribute;
import controller.Action;
import databean.FacebookUser;

/**
 * Action for facebook get profile,
 * including login user profile, login user friends, login user feeds wall
 * 
 * @author shiqing
 *
 */
public class FacebookProfileAction extends Action {
	public FacebookProfileAction(Model model){}

	@Override
	public String getActionName() {
		return "fb_FacebookProfile.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		FacebookClient facebookClient = (FacebookClient) request.getSession().getAttribute(SessionUserAttribute.FACEBOOK_USER.getValue());

		// Get login user, user's friends, user's profile feed wall
		User loginUser = facebookClient.fetchObject("me", User.class);
		Connection<User> friends = facebookClient.fetchConnection("me/friends", User.class);
		Connection<Post> feeds = facebookClient.fetchConnection("me/feed", Post.class);
		
		// Get friends information
		List<FacebookUser> myFriends = FacebookUtil.get().fetchUserInfoFromIds(facebookClient, friends, FacebookUtil.PROFILE_FRIENDS);
		
		// Set attribute in the request
		request.setAttribute("loginUser", loginUser);
		request.setAttribute("myFriends", myFriends);
		request.setAttribute("myFeeds", feeds.getData());
		
		return "view/facebook/FacebookProfile.jsp";
	}
	
	public String getYear(String fullTime) {
		if (fullTime == null || fullTime.length() == 0) {
			return fullTime;
		} else {
			return fullTime.substring(fullTime.length()-4);
		}
	}

}
