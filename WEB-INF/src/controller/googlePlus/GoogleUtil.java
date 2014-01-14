package controller.googlePlus;

import javax.servlet.http.HttpServletRequest;

import Util.BaseUtil;

import com.googlecode.googleplus.GooglePlusFactory;
import com.googlecode.googleplus.Plus;

/**
 * Google+ Stuff Util Class
 * Singleton pattern, only one google util instance
 * 
 * @author shiqing
 *
 */
public class GoogleUtil extends BaseUtil {
	private static GoogleUtil googleUtil;
	private static final String CLIENT_ID = "google.clientId";
	private static final String CLIENT_SECRET = "google.clientSecret";
	private static final String ACCESS_TOKEN = "access_token";
	
	private GoogleUtil() {
		
	}
	
	public static GoogleUtil get() {
		if (googleUtil == null) {
			// If two threads run at the same time
			// http://en.wikipedia.org/wiki/Singleton_pattern#Example
			synchronized (GoogleUtil.class) {
				if (googleUtil == null) {
					googleUtil = new GoogleUtil();
				}
			}
		}
		return googleUtil;
	}
	
	@Override
	protected String getKey() {
		return CLIENT_ID;
	}

	@Override
	protected String getSecret() {
		return CLIENT_SECRET;
	}

	/**
	 * All remaining google+ plus api call should reply on this plus instance
	 * @param request
	 * @return
	 */
	public Plus getGooglePlusInstance(HttpServletRequest request) {
		GooglePlusFactory factory = new GooglePlusFactory(
				getKey(), 
				getSecret());
		// the refreshListener is notified in case a new access token is obtained after the old one expires
		String accessToken = request.getParameter(ACCESS_TOKEN);
		Plus plus = factory.getApi(accessToken, null, null);
		
		return plus;
	}
}
