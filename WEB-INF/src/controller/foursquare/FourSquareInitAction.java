package controller.foursquare;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import rest.foursquare.FourSquareFactory;
import configuration.SessionUserAttribute;
import controller.Action;
import fi.foyt.foursquare.api.FoursquareApi;

/**
 * Action to instantiate the FourSquare api call endpoint client
 * 
 * @author shiqing
 *
 */
public class FourSquareInitAction extends Action {
	public FourSquareInitAction(Model model){}

	@Override
	public String getActionName() {
		return "fs_FourSquareInit.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// Switch the code to access token
		String code = request.getParameter("code");
		String accessToken = FourSquareFactory.get().getOauthService().getAccessToken(code);
		
		// Instantiate the FourSquare client with access token
	    FoursquareApi foursquareApi = new FoursquareApi(
	    								FourSquareUtil.get().getKeyAndSecretSetting().getKey(), 
	    								FourSquareUtil.get().getKeyAndSecretSetting().getSecret(), 
	    								FourSquareUtil.getCallbackUrl());
	    foursquareApi.setoAuthToken(accessToken);
	    request.getSession().setAttribute(SessionUserAttribute.FOURSQUARE_USER.getValue(), foursquareApi);
	    
	    return "fs_FourSquareHome.do";
	}
}
