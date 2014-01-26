package rest.foursquare;

import rest.foursquare.intf.FourSquareClientIntf;
import rest.foursquare.intf.FourSquareOauthServiceIntf;

/**
 * Factory for FourSquare
 * 
 * @author shiqing
 *
 */
public class FourSquareFactory {
	private static FourSquareFactory fourSquareFactory;
	
	private FourSquareFactory () {
		
	}
	
	public static FourSquareFactory get() {
		if (fourSquareFactory == null) {
			synchronized (FourSquareFactory .class) {
				if (fourSquareFactory == null) {
					fourSquareFactory = new FourSquareFactory ();
				}
			}
		}
		return fourSquareFactory;
	}
	
	public FourSquareOauthServiceIntf getOauthService() {
		return new FourSquareOauthService();
	}
	
	public FourSquareClientIntf getFourSquareClient(String accessToken) {
		return new FourSquareClient(accessToken);
	}
}
