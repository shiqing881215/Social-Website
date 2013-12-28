package controller.twitter;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;
import controller.Action;

/**
 * 
 * Action used to get the request token.
 * To get the request token, twitter needs your app consumer key and consumer secret
 * you can also specify the callback url
 * Then send a POST request to https://api.twitter.com/oauth/request_token, those parameters are in request header
 * 
 * This action is called when you click the twitter button in the welcome.jsp, then initialize this action to get the request token.  
 * 
 * see detail at https://dev.twitter.com/docs/api/1/post/oauth/request_token
 * 
 * @author shiqing
 * 
 */
public class OauthRequestTokenAction extends Action {
	
	public OauthRequestTokenAction(Model model) {
	}
	
	@Override
	public String getActionName() {
		return "tw_OauthRequestToken.do";
	}

	/**
	 * Generate the request token and then go to the TwitterLogin.jsp with login button
	 */
	@Override
	public String perform(HttpServletRequest request) {
		try {
			// Get Twitter single instance
			Twitter twitter = TwitterUtil.get().getTwitterInstance();
			if (twitter == null) {
				return "error.jsp";
			}
			
			// Set the callback url which will generate the access token
			RequestToken requestToken = twitter.getOAuthRequestToken("http://localhost:8080/BWeb/tw_OauthAccessToken.do");
			
			System.out.println("Got request token.");
	        System.out.println("Request token: " + requestToken.getToken());
	        System.out.println("Request token secret: " + requestToken.getTokenSecret());
	        
	        // Here is the tricky part, include the request token as an attribute in the request
	        // which will be used to insert into the twitter.jsp and used by twitter.js to open the authenticate twitter page
	        request.setAttribute("requestToken", requestToken.getToken());
	        
	        // Attention, store the twitter instance in the session, which will be used by the following twitter calls
	        // like get access token, do twitter api calls. 
	        // It is needed use the single instance, otherwise it will give the no token available exception.
	        request.getSession().setAttribute("twitterInstance", twitter);
	        
	        return "view/twitter/TwitterLogin.jsp";
		} catch (TwitterException e) {
			e.printStackTrace();
			return "error.jsp";
		}
	}
}
