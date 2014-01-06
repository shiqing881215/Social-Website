package controller.twitter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import twitter4j.ResponseList;
//import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
//import twitter4j.auth.AccessToken;
import configuration.SessionUserAttribute;
import controller.Action;
import databean.TwitterUser;

/**
 * This action is responsible for getting the user search result from twitter.
 * Then it shows on the TwitterSearch.jsp
 * 
 * @author shiqing
 *
 */
public class TwitterSearchAction extends Action {

	public TwitterSearchAction(Model model) {
	}
	
	@Override
	public String getActionName() {
		return "tw_TwitterSearch.do";
	}

	/**
	 * Do two things here
	 * (1) Do the search action
	 * (2) Do get login user action to use the login user background image
	 */
	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
//		AccessToken accessToken = (AccessToken) session.getAttribute("accessToken");
//		Twitter twitter = (Twitter) (session.getAttribute("twitterInstance"));
//		
//		twitter.setOAuthAccessToken(accessToken);
		
		Twitter twitter = (Twitter) (session.getAttribute(SessionUserAttribute.TWITTER_USER.getValue()));
		
		try {
			// Do user search stuff
			String query = request.getParameter("twitterUser");
			int page = 1;
	        ResponseList<User> users;
	        List<TwitterUser> twUsers = new ArrayList<TwitterUser>();
	        TwitterUser twUser;
            users = twitter.searchUsers(query, page);
            for (User user : users) {
            	twUser = new TwitterUser(user);
            	twUsers.add(twUser);
            }
            request.setAttribute("twUserSearchList", twUsers);
            
            // Get login user information
            // TODO : remove this piece of code to reuse the login user information
            User loginUser = twitter.showUser(twitter.getScreenName());
            TwitterUser twLoginUser = new TwitterUser(loginUser);
            
            request.setAttribute("loginTwitterUser", twLoginUser);
            
            return "view/twitter/TwitterSearch.jsp";
		} catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search users: " + te.getMessage());
            
            return "error.jsp";
        }
	}
}
