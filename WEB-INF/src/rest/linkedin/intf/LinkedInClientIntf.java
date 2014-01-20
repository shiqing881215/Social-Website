package rest.linkedin.intf;

import java.util.List;

import rest.linkedin.LinkedInUser;

/**
 * Interface for LinkedInClient
 * 
 * @author shiqing
 *
 */
public interface LinkedInClientIntf {
	public LinkedInUser getLoginUser();
	
	public List<LinkedInUser> getLoginUserConnections();
}
