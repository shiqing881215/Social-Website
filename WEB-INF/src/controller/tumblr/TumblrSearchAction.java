package controller.tumblr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;

import configuration.SessionUserAttribute;
import controller.Action;
import databean.tumblr.TumblrSearchUser;

/**
 * Search action for Tumblr
 * You need to give the exact user name to handle search
 * Not support fuzzy search
 * 
 * @author shiqing
 *
 */
public class TumblrSearchAction extends Action {
	public TumblrSearchAction(Model model) {}

	@Override
	public String getActionName() {
		return "tb_TumblrSearch.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		JumblrClient tumblrClient = (JumblrClient) request.getSession().getAttribute(SessionUserAttribute.TUMBLR_USER.getValue());
		if (tumblrClient == null) {
			return "tb_TumblrRequestToken.do";
		}
		
		String query = request.getParameter("tumblrUser");
		try {
			Blog blog = tumblrClient.blogInfo(query);
			String avater = tumblrClient.blogAvatar(query);
			List<Post> likes = tumblrClient.blogLikes(query);
			List<Post> posts = tumblrClient.blogPosts(query);
			
			TumblrSearchUser user = new TumblrSearchUser(blog, avater, likes, posts);
			request.setAttribute("user", user);
		} catch (Exception e) {
			// TODO log
			request.setAttribute("tumblrUser", query);
		}
		
		return "/view/tumblr/TumblrSearch.jsp";
	}
}
