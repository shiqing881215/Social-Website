package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import configuration.SessionUserAttribute;

import model.Model;

/**
 * Logout action to reset all user info in session to null and back to login page.
 * 
 * @author shiqing
 *
 */
public class LogoutAction extends Action{
	
	public LogoutAction(Model model){}

	@Override
	public String getActionName() {
		return "logout.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		clearSessionUser(session);
		return "/view/login.jsp";
	}
	
	/**
	 * Clean all user object in session when logout
	 * @param session
	 */
	private void clearSessionUser(HttpSession session) {
		for (SessionUserAttribute user : SessionUserAttribute.values()) {
			session.setAttribute(user.getValue(), null);
		}
	}
}
