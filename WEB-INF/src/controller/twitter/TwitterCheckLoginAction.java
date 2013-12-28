package controller.twitter;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import controller.Action;

/**
 * Action to check whether user already login to twitter.
 * If user already login to twitter, go to the timeline directly.
 * Otherwise go to the login page.
 * 
 * @author shiqing
 *
 */
public class TwitterCheckLoginAction extends Action {
	public TwitterCheckLoginAction(Model model) {}

	@Override
	public String getActionName() {
		return "tw_CheckLogin.do";
	}

	@Override
	/**
	 * If user already login to twitter, go to the timeline directly.
	 * Otherwise go to the login page.
	 */
	public String perform(HttpServletRequest request) {
		Twitter twitter = (Twitter)(request.getSession().getAttribute("twitterInstance"));
		if (twitter != null) {
			try {
				if (twitter.getOAuthAccessToken() != null) {
					return "tw_TwitterTimeline.do";  
				} else {
					return "tw_OauthRequestToken.do";
				}
			} catch (TwitterException e) {
				return "tw_OauthRequestToken.do";
			}
			
		} else {
			return "tw_OauthRequestToken.do";
		}
	}
}
