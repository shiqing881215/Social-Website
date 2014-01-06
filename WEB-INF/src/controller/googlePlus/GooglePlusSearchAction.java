package controller.googlePlus;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import com.googlecode.googleplus.Plus;
//import com.googlecode.googleplus.model.person.PersonFeed;

import configuration.SessionUserAttribute;
import controller.Action;

/**
 * Google+ search
 * 
 * @author shiqing
 *
 */
public class GooglePlusSearchAction extends Action {
	public GooglePlusSearchAction(Model model){}

	@Override
	public String getActionName() {
		return "gp_GooglePlusSearch.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		Plus plus = (Plus) request.getSession().getAttribute(SessionUserAttribute.GOOGLE_USER.getValue());
		String query = request.getParameter("googlePlusUser");
		// TODO : Unrecognized field "etag" Exception, because can not map the field etag in the response json
		plus.getPeopleOperations().search(query);
		return null;
	}
}
