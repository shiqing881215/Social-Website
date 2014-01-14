package controller.instagram;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import com.sola.instagram.model.User;

import configuration.SessionUserAttribute;
import controller.Action;
import databean.instagram.InstagramClient;

public class InstagramSearchAction extends Action {
	public InstagramSearchAction(Model model){}

	@Override
	public String getActionName() {
		return "ins_InstagramSearch.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		InstagramClient instagramClient = (InstagramClient) request.getSession().getAttribute(SessionUserAttribute.INSTAGRAM_USER.getValue());
		if (instagramClient == null) {
			return "/view/instagram/InstagramLogin.jsp";
		} 
		try {
			String query = request.getParameter("instagramUser");
			ArrayList<User> users = (ArrayList<User>) instagramClient.getInstagramSession().searchUsersByName(query);
			request.setAttribute("insUserSearchList", users);
			
			return "view/instagram/InstagramSearch.jsp";
		} catch (Exception e) {
			// TODO Log
			return "/view/error.jsp";
		}
	}

}
