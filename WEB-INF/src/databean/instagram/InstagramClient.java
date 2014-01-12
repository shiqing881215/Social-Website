package databean.instagram;

import com.sola.instagram.InstagramSession;

/**
 * This is the wrapper class of InstagramSession.
 * Store additional access token information to take care of missing endpoint call from library 
 * like https://api.instagram.com/v1/users/self
 * 
 * @author shiqing
 *
 */
public class InstagramClient {
	private InstagramSession instagramSession;
	private String accessToken;
	
	public InstagramClient(InstagramSession instagramSession, String accessToken) {
		this.instagramSession = instagramSession;
		this.accessToken = accessToken;
	}
	
	public InstagramSession getInstagramSession() {
		return instagramSession;
	}
	public void setInstagramSession(InstagramSession instagramSession) {
		this.instagramSession = instagramSession;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
