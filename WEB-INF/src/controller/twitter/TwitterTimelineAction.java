package controller.twitter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
//import twitter4j.auth.AccessToken;
import controller.Action;
import databean.Tweet;
import databean.TwitterUser;

/**
 * This action is responsible for 
 * (1) Getting the login user information
 * (2) Getting the login user timeline
 * (3) Getting the login user home timeline
 * Then it  will show all these three information on the twitter.jsp
 * 
 * @author shiqing
 *
 */
public class TwitterTimelineAction extends Action{

	public TwitterTimelineAction(Model model) {
	}
	
	@Override
	public String getActionName() {
		return "tw_TwitterTimeline.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Twitter twitter = (Twitter) (session.getAttribute("twitterInstance"));
		
		try {
			// Get login user
            User user = twitter.showUser(twitter.getScreenName());
            TwitterUser twUser = new TwitterUser(user);
            
            // Get user timeline
            Tweet tweet;
            List<Tweet> userTimeline = new ArrayList<Tweet>();
            List<Status> statuses = twitter.getUserTimeline(twitter.getScreenName());
            for (Status status : statuses) {
            	tweet = new Tweet(status, twitter);
            	userTimeline.add(tweet);
            }
            
            // Get home timeline
            List<Tweet> homeTimeline = new ArrayList<Tweet>();
            statuses = twitter.getHomeTimeline();
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            for (Status status : statuses) {
            	tweet = new Tweet(status, twitter);
            	homeTimeline.add(tweet);
            }
            
            request.setAttribute("loginTwitterUser", twUser);
            request.setAttribute("userTimeLine", userTimeline);
            request.setAttribute("homeTimeLine", homeTimeline);
            
            return "view/twitter/TwitterTimeline.jsp";
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to delete status: " + te.getMessage());
            return "error.jsp";
        }
	}
}
