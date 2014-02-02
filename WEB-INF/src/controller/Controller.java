package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import configuration.SessionUserAttribute;
import controller.facebook.FacebookCheckLoginAction;
import controller.facebook.FacebookLoginAction;
import controller.facebook.FacebookProfileAction;
import controller.facebook.FacebookSearchAction;
import controller.foursquare.FourSquareCheckLoginAction;
import controller.foursquare.FourSquareHomeAction;
import controller.foursquare.FourSquareInitAction;
import controller.foursquare.FourSquareSearchAction;
import controller.googlePlus.GooglePlusCheckLoginAction;
import controller.googlePlus.GooglePlusInitAction;
import controller.googlePlus.GooglePlusProfileAction;
import controller.googlePlus.GooglePlusSearchAction;
import controller.instagram.InstagramCheckLoginAction;
import controller.instagram.InstagramHomeAction;
import controller.instagram.InstagramInitAction;
import controller.instagram.InstagramSearchAction;
import controller.linkedin.LinkedInCheckLoginAction;
import controller.linkedin.LinkedInHomeAction;
import controller.linkedin.LinkedInInitAction;
import controller.tumblr.TumblrCheckLoginAction;
import controller.tumblr.TumblrDashboardAction;
import controller.tumblr.TumblrInitAction;
import controller.tumblr.TumblrRequestTokenAction;
import controller.twitter.OauthAccessTokenAction;
import controller.twitter.OauthRequestTokenAction;
import controller.twitter.TwitterCheckLoginAction;
import controller.twitter.TwitterSearchAction;
import controller.twitter.TwitterTimelineAction;
import databean.User;

/**
 * Class handle http calls.
 * Map request to the right action.
 * Forward the response to right view.
 * 
 * @author shiqing
 *
 */
public class Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// Each time when you add new action. remember to add the new action into the action map in this method
	public void init() throws ServletException{
		// Init model, which means getting the connection with db
		Model model = new Model(getServletConfig());
		
		Action.add(new LoginAction(model));
		Action.add(new LogoutAction(model));
		Action.add(new SearchAjaxAction(model));
		
		Action.add(new OauthAccessTokenAction(model));
		Action.add(new OauthRequestTokenAction(model));
		Action.add(new TwitterCheckLoginAction(model));
		Action.add(new TwitterSearchAction(model));
		Action.add(new TwitterTimelineAction(model));
		
		Action.add(new FacebookLoginAction(model));
		Action.add(new FacebookCheckLoginAction(model));
		Action.add(new FacebookSearchAction(model));
		Action.add(new FacebookProfileAction(model));
		
		Action.add(new GooglePlusProfileAction(model));
		Action.add(new GooglePlusCheckLoginAction(model));
		Action.add(new GooglePlusInitAction(model));
		Action.add(new GooglePlusSearchAction(model));
		
		Action.add(new InstagramInitAction(model));
		Action.add(new InstagramHomeAction(model));
		Action.add(new InstagramCheckLoginAction(model));
		Action.add(new InstagramSearchAction(model));
		
		Action.add(new LinkedInCheckLoginAction(model));
		Action.add(new LinkedInInitAction(model));
		Action.add(new LinkedInHomeAction(model));
		
		Action.add(new FourSquareCheckLoginAction(model));
		Action.add(new FourSquareInitAction(model));
		Action.add(new FourSquareHomeAction(model));
		Action.add(new FourSquareSearchAction(model));
		
		Action.add(new TumblrCheckLoginAction(model));
		Action.add(new TumblrRequestTokenAction(model));
		Action.add(new TumblrInitAction(model));
		Action.add(new TumblrDashboardAction(model));
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = performTheAction(request);
		sendToNextPage(nextPage, request, response);
	}


	private String performTheAction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String servletPath = request.getServletPath();
		User user = (User)session.getAttribute(SessionUserAttribute.SOCIAL_PLUS_USER.getValue());
		String action = getActionName(servletPath);
		
		if (user == null) {
			return Action.perform("login.do", request);
		}
		
		return Action.perform(action, request);
	}

	/*
     * If nextPage is null, send back 404
     * If nextPage ends with ".do", redirect to this page.
     * If nextPage ends with ".jsp", dispatch (forward) to the page (the view)
     *    This is the common case
     */
	private void sendToNextPage(String nextPage, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (nextPage == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, request.getServletPath());
			return;
		}
		
		// Treat .do and .jsp in different ways
		// .do should send another request (which can be done in redirect)
		// .jsp just forward to display
		
		if (nextPage.endsWith(".do")) {
			response.sendRedirect(nextPage);  // Update URL with the nextPage.do and ask for another new request
			return;
		}
		
		if (nextPage.endsWith(".jsp") || nextPage.endsWith(".html")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
			requestDispatcher.forward(request, response);
			return;
		}
		
		throw new ServletException(Controller.class.getName() + ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
	}
	
	// Get the action name which is appended after the url, like "login.do"
	private String getActionName(String servletPath) {
//		int lastSlash = servletPath.lastIndexOf("/");
//		return servletPath.substring(lastSlash+1);
		
		// Remove the first slash, allow multi-level action like "twitter/TwitterSearch.do" 
		return servletPath.substring(1);
	}
}
