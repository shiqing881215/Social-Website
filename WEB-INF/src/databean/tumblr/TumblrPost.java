package databean.tumblr;

import com.tumblr.jumblr.types.PhotoPost;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.TextPost;

/**
 * Tumblr general post
 * including TextPost, PhotoPost, VideoPost
 * 
 * @author shiqing
 *
 */
public class TumblrPost {
	// Generic post
	private Post post;
	// Text post
	private String title;
	private String body;
	// Photo post
	private String imageUrl;
	// Video post
	
	public TumblrPost(Post post) {
		this.post = post;
		if (post instanceof TextPost) {
			this.title = ((TextPost)post).getTitle();
			this.body = ((TextPost)post).getBody();
		} else if (post instanceof PhotoPost) {
			this.imageUrl = extractImageUrl(((PhotoPost)post).getCaption());
		}
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	private String extractImageUrl(String caption) {
		// TODO Auto-generated method stub
		return null;
	}
}
