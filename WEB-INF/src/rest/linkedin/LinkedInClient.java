package rest.linkedin;

import java.util.List;

import rest.linkedin.intf.LinkedInClientIntf;
import rest.social.UrlGenerator;
import Util.HttpClient;

/**
 * LinkedIn client to handle all endpoint restful api calls.
 * 
 * @author shiqing
 *
 */
public class LinkedInClient implements LinkedInClientIntf {
	private String accessToken;
	
	public LinkedInClient(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public LinkedInUser getLoginUser() {
		try {
			String response = HttpClient.sendGet(UrlGenerator.getLinkedInCurrentUserUrl(accessToken));
			return LinkedInXMLParser.extractLoginUserInfo(response);
		} catch (Exception e) {
			// TODO log
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LinkedInUser> getLoginUserConnections() {
		try {
			String response = HttpClient.sendGet(UrlGenerator.getLinkedInCurrentUserConnectionUrl(accessToken));
			return LinkedInXMLParser.extractLoginUserConnections(response);
		} catch (Exception e) {
			// TODO log
			e.printStackTrace();
			return null;
		}
	}
}
