package controller.linkedin;

import Util.BaseUtil;

/**
 * LinkedIn Util 
 * 
 * @author shiqing
 *
 */
public class LinkedInUtil extends BaseUtil{
	private static LinkedInUtil linkedInUtil;
	
	private static final String CALLBACK_URL = "http://localhost:8080/BWeb/linkedin_LinkedInInit.do";
	private static final String STATE = "DCEEFWF45453sdffef424";
	public static final int CONNECTION_LIMIT = 20;
	
	private static final String API_KEY = "linkedin.apiKey";
	private static final String SECRET_KEY = "linkedin.secretKey";
	
	
	private LinkedInUtil() {
		// do nothing, private constructor
	}
	
	public static LinkedInUtil get() {
		if (linkedInUtil == null) {
			// If two threads run at the same time
			// http://en.wikipedia.org/wiki/Singleton_pattern#Example
			synchronized (LinkedInUtil.class) {
				if (linkedInUtil == null) {
					linkedInUtil = new LinkedInUtil();
				}
			}
		}
		return linkedInUtil;
	}
	
	public String getState() {
		return STATE;
	}
	
	public String getCallbackUrl() {
		return CALLBACK_URL;
	}
	
	@Override
	protected String getKey() {
		return API_KEY;
	}

	@Override
	protected String getSecret() {
		return SECRET_KEY;
	}
}
