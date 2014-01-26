package rest.foursquare.intf;

/**
 * Interface for FourSquare oauth service.
 * @author shiqing
 *
 */
public interface FourSquareOauthServiceIntf {
	
	/**
	 * https://foursquare.com/oauth2/authenticate
     * 			?client_id=YOUR_CLIENT_ID
     *			&response_type=code
     *			&redirect_uri=YOUR_REGISTERED_REDIRECT_URI
	 * @return     YOUR_REGISTERED_REDIRECT_URI/?code=CODE
	 */
	public String getCode();
	
	/**
	 * https://foursquare.com/oauth2/access_token
     *		?client_id=YOUR_CLIENT_ID
     *		&client_secret=YOUR_CLIENT_SECRET
     *		&grant_type=authorization_code
     *		&redirect_uri=YOUR_REGISTERED_REDIRECT_URI
     *		&code=CODE
	 * @param code
	 * @return { access_token: ACCESS_TOKEN }
	 */
	public String getAccessToken(String code);
}
