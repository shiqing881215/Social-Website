package controller.foursquare;

import Util.BaseUtil;

/**
 * Util for FourSquare operation
 * 
 * @author shiqing
 *
 */
public class FourSquareUtil extends BaseUtil {
	private static FourSquareUtil fourSquareUtil;
	private static final String CLIENT_ID = "foursquare.clientId";
	private static final String CLIENT_SECRET = "foursquare.clientSecret";
	private static final String CALLBACK_URL = "http://localhost:8080/BWeb/fs_FourSquareInit.do";
	
	private FourSquareUtil() {
		
	}
	
	public static FourSquareUtil get() {
		if (fourSquareUtil == null) {
			// If two threads run at the same time
			// http://en.wikipedia.org/wiki/Singleton_pattern#Example
			synchronized (FourSquareUtil.class) {
				if (fourSquareUtil == null) {
					fourSquareUtil = new FourSquareUtil();
				}
			}
		}
		return fourSquareUtil;
	}
	
	@Override
	protected String getKey() {
		return CLIENT_ID;
	}

	@Override
	protected String getSecret() {
		return CLIENT_SECRET;
	}

	public static String getCallbackUrl() {
		return CALLBACK_URL;
	}
}
