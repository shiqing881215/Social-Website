package controller.tumblr;

import Util.BaseUtil;

/**
 * Tumblr Util
 * 
 * @author shiqing
 *
 */
public class TumblrUtil extends BaseUtil {
	private static TumblrUtil tumblrUtil;
	
	private static final String CALLBACK_URL = "http://localhost:8080/BWeb/tb_TumblrInit.do";
	
	private static final String CONSUMER_KEY = "tumblr.consumerKey";
	private static final String SECRET_KEY = "tumblr.secretKey";
	
	private TumblrUtil() {
		
	}
	
	public static TumblrUtil get() {
		if (tumblrUtil == null) {
			synchronized (TumblrUtil.class) {
				if (tumblrUtil == null) {
					tumblrUtil = new TumblrUtil();
				}
			}
		}
		return tumblrUtil;
	}
	
	@Override
	protected String getKey() {
		return CONSUMER_KEY;
	}

	@Override
	protected String getSecret() {
		return SECRET_KEY;
	}

	public static String getCallbackUrl() {
		return CALLBACK_URL;
	}
}
