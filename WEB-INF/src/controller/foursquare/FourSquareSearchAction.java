package controller.foursquare;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import configuration.SessionUserAttribute;
import controller.Action;
import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompactUser;

public class FourSquareSearchAction extends Action {
	public FourSquareSearchAction(Model model){}

	@Override
	public String getActionName() {
		return "fs_FourSquareSearch.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		FoursquareApi fourSquareClient = (FoursquareApi) request.getSession().getAttribute(SessionUserAttribute.FOURSQUARE_USER.getValue());
		if (fourSquareClient == null) {
			return "/view/foursquare/FourSquareLogin.jsp";
		}

	    try {
			String queryName = request.getParameter("fourSquareUser");
			Result<CompactUser[]> loginUser = fourSquareClient.usersSearch(null, null, null, null, null, queryName);
			if (loginUser.getMeta().getCode() != 200) {
				return "/view/foursquare/FourSquareLogin.jsp";
			} else {
				request.setAttribute("users", loginUser.getResult());
				return "/view/foursquare/FourSquareSearch.jsp";
			}
		} catch (FoursquareApiException e) {
			// TODO log
			e.printStackTrace();
			return "/view/foursquare/FourSquareLogin.jsp";
		}
	}

}
