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
}
