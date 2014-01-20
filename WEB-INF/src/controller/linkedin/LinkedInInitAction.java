package controller.linkedin;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import rest.linkedin.LinkedInFactory;
import rest.linkedin.intf.LinkedInClientIntf;
import rest.linkedin.intf.LinkedInOauthServiceIntf;
import configuration.SessionUserAttribute;
import controller.Action;

/**
 * LinkedIn initialize action to create the LinkedInClient
 * 
 * @author shiqing
 *
 */
public class LinkedInInitAction extends Action {
	public LinkedInInitAction(Model model) {}
	
	@Override
	public String getActionName() {
		return "linkedin_LinkedInInit.do";
	}
	
	/**
	 * Extract the code from the callback and send another api call to linkedin to get the access token
	 */
	@Override
	public String perform(HttpServletRequest request) {
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		if (code != null && state != null) {
			if (!LinkedInUtil.get().getState().equals(state)) {
				return "/view/error.jsp";
			} 
			// Get access token
			LinkedInOauthServiceIntf oauthService = LinkedInFactory.get().getLinkedInOauthService();
			String accessToken = oauthService.getAccessToken(code);
			// Instantiate linkedin client
			LinkedInClientIntf linkedInClient = LinkedInFactory.get().getLinkedInClient(accessToken);
			request.getSession().setAttribute(SessionUserAttribute.LINKEDIN_USRE.getValue(), linkedInClient);
			
			return "linkedin_LinkedInHome.do";
		} 
		
		// If code or state is null, return to error page
		return "/view/error.jsp";
	}
}
