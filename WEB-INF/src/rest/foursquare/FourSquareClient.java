package rest.foursquare;

import rest.foursquare.intf.FourSquareClientIntf;
import Util.HttpClient;

import com.google.gson.Gson;

/**
 * Endpoint client to handle all FourSquare endpoint api calls.
 * 
 * @author shiqing
 *
 */
public class FourSquareClient implements FourSquareClientIntf {
	private String accessToken;

	public FourSquareClient(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public FourSquareUser getLoginUserProfile() {
		try {
			String response = HttpClient.sendGet("https://api.foursquare.com/v2/users/self?oauth_token=" + accessToken);
			Gson gson = new Gson();
			// TODO this will fail, FourSquareUser is not fully mapped.
			FourSquareUser user = gson.fromJson(response, FourSquareUser.class);
			
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public FourSquareUser getUserProfile(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
