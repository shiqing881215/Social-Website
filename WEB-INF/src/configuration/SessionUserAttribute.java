package configuration;

/**
 * Enum for all global user object stored in session
 * 
 * @author shiqing
 *
 */
public enum SessionUserAttribute {
	SOCIAL_PLUS_USER("user"),
	TWITTER_USER("twitterInstance"),
	FACEBOOK_USER("facebookClient"),
	GOOGLE_USER("GooglePlusClient"),
	INSTAGRAM_USER("instagramClient"),
	LINKEDIN_USRE("linkedinClient"),
	FOURSQUARE_USER("fourSquareClient"),
	TUMBLR_USER("tumblrClient");
	
	private String value;
	
	private SessionUserAttribute (String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
