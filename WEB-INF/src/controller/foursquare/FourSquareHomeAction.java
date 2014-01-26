package controller.foursquare;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import configuration.SessionUserAttribute;
import controller.Action;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CheckinGroup;
import fi.foyt.foursquare.api.entities.CompleteUser;

/**
 * Home action for FourSquare. Getting login user profile.
 * 
 * @author shiqing
 *
 */
public class FourSquareHomeAction extends Action {
	public FourSquareHomeAction(Model model){}

	@Override
	public String getActionName() {
		return "fs_FourSquareHome.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		FoursquareApi fourSquareClient = (FoursquareApi) request.getSession().getAttribute(SessionUserAttribute.FOURSQUARE_USER.getValue());
		if (fourSquareClient == null) {
			return "/view/foursquare/FourSquareLogin.jsp";
		}

	    try {
			Result<CompleteUser> loginUser = fourSquareClient.user("self");
			Result<CheckinGroup> checkins = fourSquareClient.usersCheckins("self", null, null, null, null);
			if (loginUser.getMeta().getCode() != 200 || checkins.getMeta().getCode() != 200) {
				return "/view/foursquare/FourSquareLogin.jsp";
			} else {
				request.setAttribute("loginUser", loginUser.getResult());
				request.setAttribute("checkins", checkins.getResult());
				return "/view/foursquare/FourSquareHome.jsp";
			}
		} catch (FoursquareApiException e) {
			// TODO log
			e.printStackTrace();
			return "/view/foursquare/FourSquareLogin.jsp";
		}
	}
}
