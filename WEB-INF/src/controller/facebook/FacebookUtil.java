package controller.facebook;

import java.util.ArrayList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.types.User;

import controller.twitter.TwitterUtil;
import databean.FacebookUser;
import Util.BaseUtil;

/**
 * Facebook Stuff Util Class
 * Singleton pattern, only one facebook util instance
 * 
 * @author shiqing
 *
 */
public class FacebookUtil extends BaseUtil{
	private static FacebookUtil facebookUtil;
	// Callback url set to login action after getting the code
	public static final String LOGIN_CALLBACK = "http%3A%2F%2Flocalhost%3A8080%2FBWeb%2Ffb_Login.do";
	public static final int SEARCH_SIZE = 20;
	public static final int PROFILE_FRIENDS = 10;
	
	private static final String APP_ID = "facebook.appId";
	private static final String SECRET_KEY = "facebook.secretKey";

	private FacebookUtil() {
		// do nothing, private constructor
	}
	
	public static FacebookUtil get() {
		if (facebookUtil == null) {
			// If two threads run at the same time
			// http://en.wikipedia.org/wiki/Singleton_pattern#Example
			synchronized (TwitterUtil.class) {
				if (facebookUtil == null) {
					facebookUtil = new FacebookUtil();
				}
			}
		}
		return facebookUtil;
	}
	
	@Override
	protected String getKey() {
		return APP_ID;
	}

	@Override
	protected String getSecret() {
		return SECRET_KEY;
	}
	
	/**
	 * Use the id to fetch the information of a user
	 * https://gragh.facebook.com/id
	 * @param facebookClient
	 * @param rawUsers
	 * @return
	 */
	public List<FacebookUser> fetchUserInfoFromIds(FacebookClient facebookClient, Connection<User> rawUsers, int sizeLimit) {
		// Get data first
		List<User> data = rawUsers.getData();
		List<FacebookUser> users = new ArrayList<FacebookUser>();
		// Default size is 20
		int searchSize = data.size() > sizeLimit? sizeLimit : data.size();
		User user;
		FacebookUser facebookUser;
		for (int i = 0; i < searchSize; i++) {
			user = facebookClient.fetchObject(data.get(i).getId(), User.class);
			facebookUser = new FacebookUser(user);
			users.add(facebookUser);
		}
		
		return users;
	}
}
