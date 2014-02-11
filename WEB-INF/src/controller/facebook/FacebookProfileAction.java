package controller.facebook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import com.google.api.client.util.Lists;
import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import com.restfb.types.Post;
import com.restfb.types.User;

import configuration.SessionUserAttribute;
import controller.Action;
import databean.FacebookUser;
import databean.facebook.FacebookFeed;
import databean.facebook.FacebookPhoto;

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

		if (facebookClient != null) {
			// Get login user, user's friends, user's profile feed wall
			User loginUser = facebookClient.fetchObject("me", User.class);
			
			// Get friends
			Connection<User> friends = facebookClient.fetchConnection("me/friends", User.class);
			List<FacebookUser> myFriends = FacebookUtil.get().fetchUserInfoFromIds(facebookClient, friends, FacebookUtil.PROFILE_FRIENDS);

			// Get feeds
			Connection<Post> feeds = facebookClient.fetchConnection("me/feed", Post.class);
			List<FacebookFeed> myFeeds = Lists.newArrayList();
			FacebookFeed facebookFeed;
			for (Post post : feeds.getData()) {
				if (!(post.getMessage() == null || post.getMessage().equals(""))) {
					facebookFeed = new FacebookFeed(post);
					myFeeds.add(facebookFeed);
				}
			}
			
			// Get user's tagged photo
			List<FacebookPhoto> myPhotoTags = Lists.newArrayList();
			FacebookPhoto photoTag;
			JsonObject photosConnection = facebookClient.fetchObject("me/photos", JsonObject.class);
			JsonArray photosConnectionData = photosConnection.getJsonArray("data");
			for (int i = 0; i < photosConnectionData.length(); i++) {
				photoTag = new FacebookPhoto(photosConnectionData.getJsonObject(i));
				myPhotoTags.add(photoTag);
			}
			
			
			// Set attribute in the request
			request.setAttribute("loginUser", loginUser);
			request.setAttribute("myFriends", myFriends);
			request.setAttribute("myFeeds", myFeeds);
			request.setAttribute("myTagPhotos", myPhotoTags);
			
			return "view/facebook/FacebookProfile.jsp";
		} else {
			return "view/facebook/FacebookLogin.jsp";
		}
	}
	
	public String getYear(String fullTime) {
		if (fullTime == null || fullTime.length() == 0) {
			return fullTime;
		} else {
			return fullTime.substring(fullTime.length()-4);
		}
	}

}
