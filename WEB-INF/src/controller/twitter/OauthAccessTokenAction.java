package controller.twitter;

import javax.servlet.http.HttpServletRequest;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

import model.Model;

import controller.Action;

/**
 * This action is used to deal with the callback url after user authorize the twitter app.
 * url should be like :  localhost:8080/BWeb/oauthAccessToken.do?oauth_token=*******&oauth_verifier=******
 * Twitter will use this request token and verifier to get the access token finally.
 * 
 * This action is used to map this callback url to do the twitter get access token background then return to the original twitter page.
 * Send POST request to https://api.twitter.com/oauth/access_token 
 * 
 * This action is called when user hit the login button in the twitter.jsp, then it redirects to the twitter page, 
 * after user hit authenticate button on the twitter page, it goes to the callback url and trigger this action background to get access token.
 * 
 * see detail at https://dev.twitter.com/docs/api/1/post/oauth/access_token
 * 
 * @author shiqing
 *
 */
public class OauthAccessTokenAction extends Action {
	private static final int VERIFIER_LENGTH = 15;

	public OauthAccessTokenAction(Model model) {
	}
	
	@Override
	public String getActionName() {
		return "tw_OauthAccessToken.do";
	}

	/**
	 * Generate the access token by using the request token verifier
	 */
	@Override
	public String perform(HttpServletRequest request) {
		String query = request.getQueryString();
		String oauth_verifier = getOauthVerifier(query);
		
		try {
			// Get the single twitter instance from session
			Twitter twitter = (Twitter) (request.getSession().getAttribute("twitterInstance"));
			
			AccessToken accessToken = twitter.getOAuthAccessToken(oauth_verifier);
			
			System.out.println("Got access token.");
	        System.out.println("Access token: " + accessToken.getToken());
	        System.out.println("Access token secret: " + accessToken.getTokenSecret());
	        
//	        request.getSession().setAttribute("accessToken", accessToken);
	        
	        twitter.setOAuthAccessToken(accessToken);
	        request.getSession().setAttribute("twitterInstance", twitter);
	        
	        return "tw_TwitterTimeline.do"; 
	        
		} catch (TwitterException e) {
			e.printStackTrace();
			
			return "error.jsp";
		}
	}
	
//	private String getOauthToken(String query) {
//		return query.substring(query.indexOf("oauth_token")+12, query.indexOf("&"));
//	}

	private String getOauthVerifier(String query) {
		return query.substring(query.indexOf("oauth_verifier") + VERIFIER_LENGTH);
	}
}
