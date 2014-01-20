package rest.linkedin.intf;

/**
 * Interface for linkedin authentication side work.
 * 
 * @author shiqing
 *
 */
public interface LinkedInOauthServiceIntf {
	
	/**
	 * Get code by sending redirect to 
	 * https://www.linkedin.com/uas/oauth2/authorization?response_type=code
     *                                      &client_id=YOUR_API_KEY
     *                                      &scope=SCOPE
     *                                      &state=STATE
     *                                      &redirect_uri=YOUR_REDIRECT_URI
	 * @return YOUR_REDIRECT_URI/?code=AUTHORIZATION_CODE&state=STATE
	 */
	public String getCode();
	
	/**
	 * Exchange access token with code by sending post to 
	 * https://www.linkedin.com/uas/oauth2/accessToken?grant_type=authorization_code
     *                                      &code=AUTHORIZATION_CODE
     *                                      &redirect_uri=YOUR_REDIRECT_URI
     *                                      &client_id=YOUR_API_KEY
     *                                      &client_secret=YOUR_SECRET_KEY
	 * @return {"expires_in":5184000,"access_token":"AQXdSP_W41_UPs5ioT_t8HESyODB4FqbkJ8LrV_5mff4gPODzOYR"}
	 */
	public String getAccessToken(String code);
}
