package controller.instagram;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import configuration.SessionUserAttribute;
import controller.Action;

public class InstagramCheckLoginAction extends Action {
	public InstagramCheckLoginAction(Model model){}

	@Override
	public String getActionName() {
		return "instagram_CheckLogin.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		if ((request.getSession().getAttribute(SessionUserAttribute.INSTAGRAM_USER.getValue())) != null) {
			return "ins_InstagramHome.do"; 
		} else {
			return "view/instagram/InstagramLogin.jsp";
		}
	}

}
