package rest.linkedin;

import rest.linkedin.intf.LinkedInClientIntf;
import rest.linkedin.intf.LinkedInOauthServiceIntf;

/**
 * Factory for LinkedIn
 * 
 * @author shiqing
 *
 */
public class LinkedInFactory {
	private static LinkedInFactory linkedInFactory;
	
	private LinkedInFactory() {
		
	}
	
	public static LinkedInFactory get() {
		if (linkedInFactory == null) {
			// If two threads run at the same time
			// http://en.wikipedia.org/wiki/Singleton_pattern#Example
			synchronized (LinkedInFactory.class) {
				if (linkedInFactory == null) {
					linkedInFactory = new LinkedInFactory();
				}
			}
		}
		return linkedInFactory;
	}
	
	public LinkedInOauthServiceIntf getLinkedInOauthService() {
		return new LinkedInOauthService();
	}
	
	public LinkedInClientIntf getLinkedInClient(String accessToken) {
		return new LinkedInClient(accessToken);
	}
}
