package controller.googlePlus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;

import com.googlecode.googleplus.GooglePlusFactory;
import com.googlecode.googleplus.Plus;

import controller.Action;

/**
 * Generate the google plus instance with access token for following api calls usage.
 * This is the first action to be called when user authenticate the google+ app with their credential
 * 
 * @author shiqing
 *
 */
public class GooglePlusInitAction extends Action {
	public GooglePlusInitAction(Model model){}

	@Override
	public String getActionName() {
		return "gp_GooglePlusInit.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		GooglePlusFactory factory = new GooglePlusFactory(
				"clientId", 
				"clientSecret");
		// the refreshListener is notified in case a new access token is obtained after the old one expires
		String accessToken = request.getParameter("access_token");
		System.out.println(accessToken);
		
		Plus plus = factory.getApi(accessToken, null, null);
		
		HttpSession session = request.getSession();
		session.setAttribute("GooglePlusClient", plus);
		
		// This is the response for ajax callback function. 
		// For this, we don't need any response, here is to init the google+ instance with access token
		// But you need give something to the callback
		// TODO change the response more meaningful
		return "/view/googlePlus/GooglePlusProfile.jsp";
	}

}
