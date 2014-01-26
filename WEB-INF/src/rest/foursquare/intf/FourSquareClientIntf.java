package rest.foursquare.intf;

import rest.foursquare.FourSquareUser;

/**
 * Interface for FourSquare endpoint client.
 * 
 * @author shiqing
 *
 */
public interface FourSquareClientIntf {
	/**
	 * Get login user profile.
	 * https://api.foursquare.com/v2/users/self?oauth_token=*****
	 * @return
	 */
	public FourSquareUser getLoginUserProfile();
	
	/**
	 * Get a certain user profile.
	 * https://api.foursquare.com/v2/users/USER_ID?oauth_token=*****
	 * @param id
	 * @return
	 */
	public FourSquareUser getUserProfile(String id);
	
	
}
