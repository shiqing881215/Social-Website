package controller.tumblr;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.tumblr.jumblr.JumblrClient;

import configuration.SessionUserAttribute;
import controller.Action;

/**
 * Tumblr initialize action
 *  
 * @author shiqing
 *
 */
public class TumblrInitAction extends Action {
	public TumblrInitAction(Model model) {}

	@Override
	public String getActionName() {
		return "tb_TumblrInit.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// Get the verifier from the callback after authorize
		String oauthVerifier = request.getParameter("oauth_verifier");
        Verifier verifier = new Verifier(oauthVerifier);
		
        // Get the access token
		Token requestToken = (Token) request.getSession().getAttribute("tumblrRequestToken");
		OAuthService service = (OAuthService) request.getSession().getAttribute("tumblrOauthService");
		Token accessToken = service.getAccessToken( requestToken ,
                verifier );
		
		// Instantiate the tumblr client
		JumblrClient tumblrClient = new JumblrClient(TumblrUtil.get().getKeyAndSecretSetting().getKey(), TumblrUtil.get().getKeyAndSecretSetting().getSecret());
		tumblrClient.setToken(accessToken.getToken(), accessToken.getSecret());
		
		request.getSession().setAttribute(SessionUserAttribute.TUMBLR_USER.getValue(), tumblrClient);
		
		return "tb_TumblrDashboard.do";
	}
}
