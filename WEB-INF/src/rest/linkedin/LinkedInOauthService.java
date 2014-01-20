package rest.linkedin;

import controller.linkedin.LinkedInUtil;
import Util.HttpClient;
import rest.linkedin.intf.LinkedInOauthServiceIntf;
import rest.social.UrlGenerator;

/**
 * LinkedIn Oauth2 service to handle all oauth work.
 * 
 * @author shiqing
 *
 */
public class LinkedInOauthService implements LinkedInOauthServiceIntf {

	@Override
	public String getAccessToken(String code) {
		String accessTokenUrl = UrlGenerator.getLinkedInOauthAceessTokenUrl(
									code, 
									LinkedInUtil.get().getCallbackUrl(), 
									LinkedInUtil.get().getKeyAndSecretSetting().getKey(), 
									LinkedInUtil.get().getKeyAndSecretSetting().getSecret());
		String accessToken;
		try {
			accessToken = HttpClient.sendPost(accessTokenUrl);
			accessToken = extractAccessToken(accessToken);
			return accessToken;
		} catch (Exception e) {
			// TODO log
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getCode() {
		// TODO
		return null;
	}

	/**
	 * Extract the token string from return json token object
	 * {"expires_in":5184000,"access_token":"AQXdSP_W41_UPs5ioT_t8HESyODB4FqbkJ8LrV_5mff4gPODzOYR"}
	 * @param tokenJson
	 * @return
	 */
	private String extractAccessToken(String tokenJson) {
		int lastColonIndex = tokenJson.lastIndexOf(":");
		int lastQuoteIndex = tokenJson.lastIndexOf("\"");
		if (lastColonIndex != -1 && lastQuoteIndex != -1) {
			return tokenJson.substring(lastColonIndex+2, lastQuoteIndex);
		}
		return null;
	}
}
