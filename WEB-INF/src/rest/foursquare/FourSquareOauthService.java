package rest.foursquare;

import java.util.Map;

import com.google.gson.Gson;

import controller.foursquare.FourSquareUtil;

import Util.HttpClient;
import rest.foursquare.intf.FourSquareOauthServiceIntf;

/**
 * Oauth service for FourSquare
 * 
 * @author shiqing
 *
 */
public class FourSquareOauthService implements FourSquareOauthServiceIntf {

	@Override
	public String getCode() {
		return null;
	}

	@Override
	public String getAccessToken(String code) {
		String accessTokenUrl = "https://foursquare.com/oauth2/access_token?" +
								"client_id=" + FourSquareUtil.get().getKeyAndSecretSetting().getKey() +
								"&client_secret=" + FourSquareUtil.get().getKeyAndSecretSetting().getSecret() +
								"&grant_type=authorization_code" +
								"&redirect_uri=" + FourSquareUtil.getCallbackUrl() +
								"&code=" + code;
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

	/**
	 * @param accessToken  {"access_token":"U24CHCU4OTRJM5ZRV53410O25RIULLTRSXSCNPA0VSPJVGII"}
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String extractAccessToken(String accessToken) {
		Gson gson = new Gson();
		Map<String, String> map = gson.fromJson(accessToken, Map.class);
		
		return map.get("access_token");
	}
}
