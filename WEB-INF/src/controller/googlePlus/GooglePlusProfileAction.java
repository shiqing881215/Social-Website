package controller.googlePlus;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import com.googlecode.googleplus.Plus;
import com.googlecode.googleplus.model.person.Person;

import controller.Action;

/**
 * Show the google+ login user profile
 * 
 * @author shiqing
 *
 */
public class GooglePlusProfileAction extends Action {
	public GooglePlusProfileAction(Model model){}

	@Override
	public String getActionName() {
		return "gp_GooglePlusProfile.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		Plus plus = (Plus) request.getSession().getAttribute("GooglePlusClient");
//		ActivityFeed activities = plus.getActivityOperations().list("me");
		Person mePerson = plus.getPeopleOperations().get("me");

		System.out.println("ID:\t" + mePerson.getId());
		System.out.println("Display Name:\t" + mePerson.getDisplayName());
		System.out.println("Image URL:\t" + mePerson.getImage().getUrl());
		System.out.println("Profile URL:\t" + mePerson.getUrl());
		
		return "/view/googlePlus/GooglePlus.jsp";
	}

}
