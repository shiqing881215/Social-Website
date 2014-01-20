package controller.linkedin;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import configuration.SessionUserAttribute;
import controller.Action;

/**
 * Check login action for linkedin
 * 
 * @author shiqing
 *
 */
public class LinkedInCheckLoginAction extends Action {
	public LinkedInCheckLoginAction(Model model){}

	@Override
	public String getActionName() {
		return "linkedin_CheckLogin.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		if ((request.getSession().getAttribute(SessionUserAttribute.LINKEDIN_USRE.getValue())) != null) {
			return "linkedin_LinkedInHome.do"; 
		} else {
			return "view/linkedin/LinkedInLogin.jsp";
		}
	}

}
