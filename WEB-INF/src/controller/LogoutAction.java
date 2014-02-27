package controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import configuration.LoggingUtil;
import configuration.SessionUserAttribute;
import databean.User;

/**
 * Logout action to reset all user info in session to null and back to login page.
 * 
 * @author shiqing
 *
 */
public class LogoutAction extends Action{
	private static Logger logger = Logger.getLogger(LogoutAction.class);

	public LogoutAction(Model model){
		DOMConfigurator.configure(LoggingUtil.get().getLoggingXml());
	}

	@Override
	public String getActionName() {
		return "logout.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		logger.info("User logout " + ((User)(session.getAttribute(SessionUserAttribute.SOCIAL_PLUS_USER.getValue()))).getUserName() + " at " + new Date());
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
