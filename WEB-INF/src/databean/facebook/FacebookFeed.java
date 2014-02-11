package databean.facebook;

import com.restfb.types.Post;

/**
 * Facebook feed wrapper
 * @author shiqing
 *
 */
public class FacebookFeed {
	private String fromId;
	private String fromName;
	private String link;
	private String message;
	
	public FacebookFeed(Post post) {
		this.fromId = post.getFrom().getId();
		this.fromName = post.getFrom().getName();
		this.link = post.getActions().get(0).getLink();
		this.message = post.getMessage();
	}
	
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
