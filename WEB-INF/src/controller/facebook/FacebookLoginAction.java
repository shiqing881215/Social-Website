package controller.facebook;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import Util.BaseUtil.Pair;

import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultWebRequestor;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.WebRequestor;

import controller.Action;

/**
 * Facebook login action after obtaining user code.
 * Here is to exchange the code into access token
 * 
 * @author shiqing
 *
 */
public class FacebookLoginAction extends Action {
	public FacebookLoginAction(Model model){}

	@Override
	public String getActionName() {
		return "fb_Login.do";
	}

	@Override
	/**
	 * Exchange code into access token and instantiate the facebook client
	 */
	public String perform(HttpServletRequest request) {
		String code = request.getParameter("code");
		
		try {
			AccessToken token = getFacebookUserToken(code, FacebookUtil.LOGIN_CALLBACK);
			String accessToken = token.getAccessToken();
			
			FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
	        request.getSession().setAttribute("facebookClient", facebookClient);

			return "fb_FacebookProfile.do";
		} catch (IOException e) {
			e.printStackTrace();
			return "error.jsp";
		}
	}
	
	/**
	 * Do the api calls to  
	 * https://graph.facebook.com/oauth/access_token?client_id={app-id}&redirect_uri={redirect-uri}&client_secret={app-secret}&code={code-parameter}
	 * to exchange the code to access token
	 * Reference :
	 * (Exchanging code for an access token)
	 * https://developers.facebook.com/docs/facebook-login/manually-build-a-login-flow/#checktoken
	 * 
	 * @param code
	 * @param redirectUrl --- must match the original redirect_url you initialize the oauth login process
	 * @return
	 * @throws IOException
	 */
	private AccessToken getFacebookUserToken(String code, String redirectUrl) throws IOException {
		Pair<String> appIdAndSecretKey = FacebookUtil.get().getKeyAndSecretSetting();
		
	    WebRequestor wr = new DefaultWebRequestor();
	    WebRequestor.Response accessTokenResponse = wr.executeGet(
	            "https://graph.facebook.com/oauth/access_token?client_id=" + appIdAndSecretKey.getKey() + "&redirect_uri=" + redirectUrl
	            + "&client_secret=" + appIdAndSecretKey.getSecret() + "&code=" + code);

	    return DefaultFacebookClient.AccessToken.fromQueryString(accessTokenResponse.getBody());
	}

}
