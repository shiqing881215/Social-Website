package controller.googlePlus;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import com.googlecode.googleplus.Plus;
import com.googlecode.googleplus.model.person.Person;
import com.googlecode.googleplus.model.person.PersonImage;

import configuration.SessionUserAttribute;
import controller.Action;

/**
 * Show the google+ login user profile
 * 
 * @author shiqing
 *
 */
public class GooglePlusProfileAction extends Action {
	private static final int IMAGE_SIZE = 200;
	
	public GooglePlusProfileAction(Model model){}

	@Override
	public String getActionName() {
		return "gp_GooglePlusProfile.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		Plus plus = (Plus) request.getSession().getAttribute(SessionUserAttribute.GOOGLE_USER.getValue());
		if (plus != null) {
			Person mePerson = plus.getPeopleOperations().get("me");
			mePerson.setImage(getResizedPersonImage(mePerson,IMAGE_SIZE));
			
			request.setAttribute("GoogleLoginUser", mePerson);
			return "/view/googlePlus/GooglePlusProfile.jsp";
		} else {
			return "/view/googlePlus/GooglePlusLogin.jsp";
		}
	}

	/**
	 * Resize the image, by default it's 50*50
	 * @param person
	 * @param imageSize
	 * @return
	 */
	private PersonImage getResizedPersonImage(Person person, int imageSize) {
		PersonImage personImage = new PersonImage();
		String url = person.getImage().getUrl();
		String resizeImageUrl = url.substring(0, url.indexOf("=")+1) + imageSize;
		personImage.setUrl(resizeImageUrl);
		return personImage;
	}
}
