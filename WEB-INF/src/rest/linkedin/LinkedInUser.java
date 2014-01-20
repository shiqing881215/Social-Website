package rest.linkedin;

/**
 * Represent as the LinkedIn user
 * 
 * @author shiqing
 *
 */
public class LinkedInUser {
	private String firstName;
	private String lastName;
	private String headline;
	private String picUrl;
	private String profileUrl;
	
	public LinkedInUser(String firstName, String lastName, String headline,
			String picUrl) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.headline = headline;
		this.picUrl = picUrl;
	}
	
	public LinkedInUser(String firstName, String lastName, String headline,
			String picUrl, String profileUrl) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.headline = headline;
		this.picUrl = picUrl;
		this.profileUrl = profileUrl;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
