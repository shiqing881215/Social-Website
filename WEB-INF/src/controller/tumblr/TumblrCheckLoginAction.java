package controller.tumblr;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import configuration.SessionUserAttribute;
import controller.Action;

/**
 * Tumblr check login action
 * 
 * @author shiqing
 *
 */
public class TumblrCheckLoginAction extends Action {
	public TumblrCheckLoginAction(Model model){}

	@Override
	public String getActionName() {
		return "tb_CheckLogin.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		if ((request.getSession().getAttribute(SessionUserAttribute.TUMBLR_USER.getValue())) != null) {
			return "tb_TumblrDashboard.do"; 
		} else {
			return "tb_TumblrRequestToken.do";
		}
	}

}
