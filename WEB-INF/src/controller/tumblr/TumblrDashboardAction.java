package controller.tumblr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import com.google.api.client.util.Lists;
import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.PhotoPost;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.TextPost;
import com.tumblr.jumblr.types.VideoPost;

import configuration.SessionUserAttribute;
import controller.Action;

/**
 * Dashboard action for Tumblr. 
 * Including all the text posts and photo posts on Tumblr 
 *
 * @author shiqing
 *
 */
public class TumblrDashboardAction extends Action {
	public TumblrDashboardAction(Model model) {}

	@Override
	public String getActionName() {
		return "tb_TumblrDashboard.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		JumblrClient tumblrClient = (JumblrClient) request.getSession().getAttribute(SessionUserAttribute.TUMBLR_USER.getValue());
		if (tumblrClient == null) {
			return "tb_TumblrRequestToken.do";
		}
		
		List<Post> posts = tumblrClient.userDashboard();
		// Right now only consider text, photo and video format post
		// TODO need to include all
		List<TextPost> textPosts = Lists.newArrayListWithCapacity(posts.size());
		List<PhotoPost> photoPosts = Lists.newArrayListWithCapacity(posts.size());
		List<VideoPost> videoPosts = Lists.newArrayListWithCapacity(posts.size());
		for (Post post : posts) {
			if (post instanceof TextPost) {
				textPosts.add((TextPost)post);
			} else if (post instanceof PhotoPost) {
				photoPosts.add((PhotoPost) post);
			} else if (post instanceof VideoPost) {
				videoPosts.add((VideoPost)post);
			}
		}
		
		request.setAttribute("textPosts", textPosts);
		request.setAttribute("photoPosts", photoPosts);
		request.setAttribute("videoPosts", videoPosts);
				
		return "/view/tumblr/TumblrDashboard.jsp";
	}
}
