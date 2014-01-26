package controller.foursquare;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import configuration.SessionUserAttribute;
import controller.Action;

public class FourSquareCheckLoginAction extends Action {
	public FourSquareCheckLoginAction(Model model){}

	@Override
	public String getActionName() {
		return "fs_CheckLogin.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		if ((request.getSession().getAttribute(SessionUserAttribute.FOURSQUARE_USER.getValue())) != null) {
			return "fs_FourSquareHome.do"; 
		} else {
			return "view/foursquare/FourSquareLogin.jsp";
		}
	}
}
