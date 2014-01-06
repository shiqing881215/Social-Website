package controller.googlePlus;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import configuration.SessionUserAttribute;
import controller.Action;

/**
 * Google+ entry point
 * Check whether user has already login to Google+.
 * If not, go to the login page.
 * If so, go to the profile page.
 * 
 * @author shiqing
 *
 */
public class GooglePlusCheckLoginAction extends Action {
	public GooglePlusCheckLoginAction(Model model){}

	@Override
	public String getActionName() {
		return "gp_CheckLogin.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		if ((request.getSession().getAttribute(SessionUserAttribute.GOOGLE_USER.getValue())) != null) {
			return "gp_GooglePlusProfile.do"; 
		} else {
			return "view/googlePlus/GooglePlusLogin.jsp";
		}
	}

}
