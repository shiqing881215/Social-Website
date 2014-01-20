package controller.linkedin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import rest.linkedin.LinkedInClient;
import rest.linkedin.LinkedInUser;
import configuration.SessionUserAttribute;
import controller.Action;

/**
 * LinkedIn home action, include login user profile and login user connection.
 * 
 * @author shiqing
 *
 */
public class LinkedInHomeAction extends Action {
	public LinkedInHomeAction(Model model) {}

	@Override
	public String getActionName() {
		return "linkedin_LinkedInHome.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		LinkedInClient linkedinClient = (LinkedInClient) request.getSession().getAttribute(SessionUserAttribute.LINKEDIN_USRE.getValue());
		if (linkedinClient == null) {
			return "/view/linkedin/LinkedinLogin.jsp";
		} 
		
		LinkedInUser loginUser = linkedinClient.getLoginUser();
		List<LinkedInUser> connections = linkedinClient.getLoginUserConnections();
		
		request.setAttribute("loginUser", loginUser);
		request.setAttribute("connections", connections);
		
		return "/view/linkedin/LinkedInHome.jsp";
	}
}
