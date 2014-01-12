package controller.instagram;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;

import com.sola.instagram.InstagramSession;
import com.sola.instagram.auth.AccessToken;

import configuration.SessionUserAttribute;
import controller.Action;
import databean.instagram.InstagramClient;

public class InstagramInitAction extends Action {
	public InstagramInitAction(Model model){}

	@Override
	public String getActionName() {
		return "ins_InstagramInit.do";
	}

	@Override
	public String perform(HttpServletRequest request) { request.getAttributeNames(); request.getHeaderNames(); request.getParameterNames(); request.getRequestURL();
	    String accessToken = extractAccessToken(request);
	    System.out.println(accessToken);
		InstagramSession instagramSession = new InstagramSession(new AccessToken(accessToken));
		InstagramClient instagramClient = new InstagramClient(instagramSession, accessToken);
		
		HttpSession session = request.getSession();
		session.setAttribute(SessionUserAttribute.INSTAGRAM_USER.getValue(), instagramClient);
		
		// Same reason as GoogleInitAction, this is the result of ajax call which is not really used
		// TODO need to refactor into some more meaningful way
		return "/view/instagram/InstagramHome.jsp";
	}
	
	/*
	 * Extract the access token from ajax call parameter
	 * The data sent from ajax call is in the format like "#access_token=1234567"
	 */
	private String extractAccessToken(HttpServletRequest request) {
	    String accessToken = request.getParameter("access_token"); 
	    return accessToken.substring(accessToken.indexOf("=")+1);
	}
}
