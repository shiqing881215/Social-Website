package controller.googlePlus;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import com.googlecode.googleplus.Plus;
import com.googlecode.googleplus.model.activity.ActivityFeed;

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
	/**
	 * This is the activity search action
	 */
	public String perform(HttpServletRequest request) {
		Plus plus = (Plus) request.getSession().getAttribute(SessionUserAttribute.GOOGLE_USER.getValue());
		if (plus != null) {
			String query = request.getParameter("googlePlusUser");
			// TODO : Unrecognized field "etag" Exception, because can not map the field etag in the response json
//			PeopleOperations peopleOperations = plus.getPeopleOperations().search(query);
			
			ActivityFeed activityFeed = plus.getActivityOperations().search(query, null);
			request.setAttribute("activities", activityFeed.getItems());
			
			return "/view/googlePlus/GooglePlusSearch.jsp";
		} else {
			return "/view/googlePlus/GooglePlusLogin.jsp";
		}
	}
}
