package rest.social;

/**
 * Class to generate all the api endpoint url
 * 
 * @author shiqing
 *
 */
public class UrlGenerator {
	private static final String LINKEDIN_BASE_API_URL = "https://api.linkedin.com";
	private static final String LINKEDIN_OAUTH = "/uas/oauth2/accessToken?grant_type=authorization_code";
	private static final String LINKEDIN_CURRENT_USER = "/v1/people/~:(first-name,last-name,headline,picture-url,public-profile-url)";
	private static final String LINKEDIN_CURRENT_USER_CONNECTION = "/v1/people/~/connections";
	private static final String LINKEDIN_OAUTH2_PARAM = "?oauth2_access_token=";
	
	private static final String FOURSQUARE_BASE_API_URL = "https://api.foursquare.com/v2";
	private static final String FOURSQUARE_OAUTH_PARAM = "?oauth_token=%s";
	private static final String FOURSQUARE_OAUTH_URL ="https://foursquare.com/oauth2/access_token?client_id=%s&client_secret=%s&grant_type=authorization_code&redirect_uri=%s&code=%s";
	private static final String FOURSQUARE_USER_PROFILE = "/users/%s";
	/**
	 * https://www.linkedin.com/uas/oauth2/accessToken?grant_type=authorization_code
     *                                      &code=AUTHORIZATION_CODE
     *                                      &redirect_uri=YOUR_REDIRECT_URI
     *                                      &client_id=YOUR_API_KEY
     *                                      &client_secret=YOUR_SECRET_KEY
	 * @param code
	 * @param redirectUri
	 * @param clientId
	 * @param clientSecret
	 * @return
	 */
	public static String getLinkedInOauthAceessTokenUrl(String code, String redirectUri, String clientId, String clientSecret) {
		StringBuilder sb = new StringBuilder(LINKEDIN_BASE_API_URL);
		sb.append(LINKEDIN_OAUTH);
		sb.append("&code=");
		sb.append(code);
		sb.append("&redirect_uri=");
		sb.append(redirectUri);
		sb.append("&client_id=");
		sb.append(clientId);
		sb.append("&client_secret=");
		sb.append(clientSecret);
		return sb.toString();
	}
	
	/**
	 * https://api.linkedin.com/v1/people/~:(first-name,last-name,headline,picture-url,public-profile-url)?oauth2_access_token=****
	 * @param accessToken
	 * @return
	 */
	public static String getLinkedInCurrentUserUrl(String accessToken) {
		StringBuilder sb = new StringBuilder(LINKEDIN_BASE_API_URL);
		sb.append(LINKEDIN_CURRENT_USER);
		sb.append(LINKEDIN_OAUTH2_PARAM);
		sb.append(accessToken);
		return sb.toString();
	}
	
	/**
	 * https://api.linkedin.com/v1/people/~/connections?oauth2_access_token=****
	 * @param accessToken
	 * @return
	 */
	public static String getLinkedInCurrentUserConnectionUrl(String accessToken) {
		StringBuilder sb = new StringBuilder(LINKEDIN_BASE_API_URL);
		sb.append(LINKEDIN_CURRENT_USER_CONNECTION);
		sb.append(LINKEDIN_OAUTH2_PARAM);
		sb.append(accessToken);
		return sb.toString();
	}
	
	/**
	 * https://foursquare.com/oauth2/access_token?client_id=%s&client_secret=%s&grant_type=authorization_code&redirect_uri=%s&code=%s
	 * @param clientId
	 * @param clientSecret
	 * @param redirectUri
	 * @param code
	 * @return
	 */
	public static String getFourSquareOauthAccessTokenUrl(String clientId, String clientSecret, String redirectUri, String code) {
		return String.format(FOURSQUARE_OAUTH_URL, clientId, clientSecret, redirectUri, code);
	}
	
	/**
	 * https://api.foursquare.com/v2/users/USER_ID?oauth_token=ACCESS_TOKEN
	 * @param userId
	 * @param accessToken
	 * @return
	 */
	public static String getFourSquareUserProfileUrl(String userId, String accessToken) {
		return String.format(FOURSQUARE_BASE_API_URL+FOURSQUARE_USER_PROFILE+FOURSQUARE_OAUTH_PARAM, userId, accessToken);
	}
}
