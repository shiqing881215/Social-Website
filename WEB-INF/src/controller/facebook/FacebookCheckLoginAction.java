package controller.facebook;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import configuration.SessionUserAttribute;
import controller.Action;

/**
 * Action to check whether user is already login facebook.
 * If user already login, go to the profile page.
 * If user not login, go to the login page.
 * 
 * @author shiqing
 *
 */
public class FacebookCheckLoginAction extends Action {
	public FacebookCheckLoginAction(Model model){}

	@Override
	public String getActionName() {
		return "fb_CheckLogin.do";
	}

	@Override
	/**
	 * If already login, go to the profile directly.
	 * Otherwise go to the login page.
	 */
	public String perform(HttpServletRequest request) {
		if ((request.getSession().getAttribute(SessionUserAttribute.FACEBOOK_USER.getValue())) != null) {
			return "fb_FacebookProfile.do"; 
		} else {
			return "view/facebook/FacebookLogin.jsp";
		}
	}
}
