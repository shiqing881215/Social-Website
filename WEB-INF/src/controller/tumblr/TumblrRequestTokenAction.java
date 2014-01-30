package controller.tumblr;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TumblrApi;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import controller.Action;

/**
 * Get the Tumblr request token.
 * Start to use scribe library for oauth stuff.
 * https://github.com/fernandezpablo85/scribe-java
 * 
 * @author shiqing
 *
 */
public class TumblrRequestTokenAction extends Action {
	public TumblrRequestTokenAction(Model model) {}

	@Override
	public String getActionName() {
		return "tb_TumblrRequestToken.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		OAuthService service = new ServiceBuilder()
        		.provider(TumblrApi.class)
        		.apiKey(TumblrUtil.get().getKeyAndSecretSetting().getKey())
        		.apiSecret(TumblrUtil.get().getKeyAndSecretSetting().getSecret())
        		.callback(TumblrUtil.getCallbackUrl()) 
        		.build();
		Token requestToken = service.getRequestToken();
		
		// Store the oauth service and request token in the session for getting access token use
		// Also store request token in the request for authorize page use in the login page
		// TODO need to figure a better way instead of saving in the session
		request.getSession().setAttribute("tumblrOauthService", service);
		request.getSession().setAttribute("tumblrRequestToken", requestToken);
		request.setAttribute("requestToken", requestToken.getToken());
		
        return "/view/tumblr/TumblrLogin.jsp";
	}
}
