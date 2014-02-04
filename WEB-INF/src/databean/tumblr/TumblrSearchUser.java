package databean.tumblr;

import java.util.List;

import com.google.api.client.util.Lists;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.PhotoPost;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.TextPost;
import com.tumblr.jumblr.types.VideoPost;

/**
 * Represent the user structure for Tumblr search result
 * 
 * @author shiqing
 *
 */
public class TumblrSearchUser {
	private Blog blog;
	private String avater;
	private List<TextPost> textLikes;
	private List<PhotoPost> photoLikes;
	private List<VideoPost> videoLikes;
	private List<TextPost> textPosts;
	private List<PhotoPost> photoPosts;
	private List<VideoPost> videoPosts;
	
	public TumblrSearchUser(Blog blog, String avater, List<Post> likes, List<Post> posts) {
		this.blog = blog;
		this.avater = avater;
		assignLikes(likes);
		assignPosts(posts);
	}
	
	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getAvater() {
		return avater;
	}

	public void setAvater(String avater) {
		this.avater = avater;
	}

	public List<TextPost> getTextLikes() {
		return textLikes;
	}

	public void setTextLikes(List<TextPost> textLikes) {
		this.textLikes = textLikes;
	}

	public List<PhotoPost> getPhotoLikes() {
		return photoLikes;
	}

	public void setPhotoLikes(List<PhotoPost> photoLikes) {
		this.photoLikes = photoLikes;
	}

	public List<VideoPost> getVideoLikes() {
		return videoLikes;
	}

	public void setVideoLikes(List<VideoPost> videoLikes) {
		this.videoLikes = videoLikes;
	}

	public List<TextPost> getTextPosts() {
		return textPosts;
	}

	public void setTextPosts(List<TextPost> textPosts) {
		this.textPosts = textPosts;
	}

	public List<PhotoPost> getPhotoPosts() {
		return photoPosts;
	}

	public void setPhotoPosts(List<PhotoPost> photoPosts) {
		this.photoPosts = photoPosts;
	}

	public List<VideoPost> getVideoPosts() {
		return videoPosts;
	}

	public void setVideoPosts(List<VideoPost> videoPosts) {
		this.videoPosts = videoPosts;
	}

	/**
	 * Distinguish text, photo, video likes
	 * 
	 * @param likes
	 */
	private void assignLikes(List<Post> likes){
		textLikes = Lists.newArrayList();
		photoLikes = Lists.newArrayList();
		videoLikes = Lists.newArrayList();
		for (Post like : likes) {
			if (like instanceof TextPost) {
				textLikes.add((TextPost)like);
			} else if (like instanceof PhotoPost) {
				photoLikes.add((PhotoPost)like);
			} else if (like instanceof VideoPost) {
				videoLikes.add((VideoPost)like);
			}
		}
	}
	
	/**
	 * Distinguish text, photo, video posts 
	 * 
	 * @param posts
	 */
	private void assignPosts(List<Post> posts) {
		textPosts = Lists.newArrayList();
		photoPosts = Lists.newArrayList();
		videoPosts = Lists.newArrayList();
		for (Post post : posts) {
			if (post instanceof TextPost) {
				textPosts.add((TextPost)post);
			} else if (post instanceof PhotoPost) {
				photoPosts.add((PhotoPost)post);
			} else if (post instanceof VideoPost) {
				videoPosts.add((VideoPost)post);
			}
		}
	}
}
