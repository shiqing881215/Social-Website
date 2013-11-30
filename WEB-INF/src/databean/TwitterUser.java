package databean;

import twitter4j.User;

/**
 * User bean for twitter user
 * @author shiqing
 *
 */
public class TwitterUser {
	private Long id;
	private String name;
	private String screenName;
	private String location;
	private String description;
	private String profileImageURL;
	private String biggerProfileImageURL;
	private String url;  
	private String profileBackgroundImageURL;
	private String profileBannerURL;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProfileImageURL() {
		return profileImageURL;
	}
	public void setProfileImageURL(String profileImageURL) {
		this.profileImageURL = profileImageURL;
	}
	public String getBiggerProfileImageURL() {
		return biggerProfileImageURL;
	}
	public void setBiggerProfileImageURL(String biggerProfileImageURL) {
		this.biggerProfileImageURL = biggerProfileImageURL;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProfileBackgroundImageURL() {
		return profileBackgroundImageURL;
	}
	public void setProfileBackgroundImageURL(String profileBackgroundImageURL) {
		this.profileBackgroundImageURL = profileBackgroundImageURL;
	}
	public String getProfileBannerURL() {
		return profileBannerURL;
	}
	public void setProfileBannerURL(String profileBannerURL) {
		this.profileBannerURL = profileBannerURL;
	}
	
	public TwitterUser(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.screenName = user.getScreenName();
		this.location = user.getLocation();
		this.description = user.getDescription();
		this.profileImageURL = user.getProfileImageURL();
		this.biggerProfileImageURL = user.getBiggerProfileImageURL();
		this.url = user.getURL();
		this.profileBackgroundImageURL = user.getProfileBackgroundImageURL();
		this.profileBannerURL = user.getProfileBannerURL();
	}
}
