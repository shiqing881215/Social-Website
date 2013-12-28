package databean;

import java.util.Date;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Databean represents the tweet in the timeline
 * @author shiqing
 *
 */
public class Tweet {
	private Date createdDate;
	private Long id;
	private String plainText;
	private String source;
	private TwitterUser twitterUser;
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlainText() {
		return plainText;
	}
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public TwitterUser getTwitterUser() {
		return twitterUser;
	}
	public void setTwitterUser(TwitterUser twitterUser) {
		this.twitterUser = twitterUser;
	}
	
	public Tweet(Status status, Twitter twitter) {
		this.createdDate = status.getCreatedAt();
		this.id = status.getId();
		this.plainText = refrainPlainText(status.getText());
		this.source = status.getSource();
		TwitterUser twUser = checkRetweet(this.plainText,twitter);
		if (twUser == null) {
			this.twitterUser = new TwitterUser(status.getUser());
		} else {
			this.twitterUser = twUser;
			this.plainText = getRetweetTweet(this.plainText);
		}
	}
	
	/**
	 * Get the retweet user (original user) if any
	 * @param tweetPlainText
	 * @param twitter
	 * @return
	 */
	private TwitterUser checkRetweet(String tweetPlainText, Twitter twitter) {
		if (tweetPlainText.startsWith("RT")) {
			String screenName = tweetPlainText.substring(tweetPlainText.indexOf("@")+1, tweetPlainText.indexOf(":"));
			try {
				return new TwitterUser(twitter.showUser(screenName));
			} catch (TwitterException e) {
				return null;
			}
		}
		
		return null;
	}
	
	/**
	 * Remove RT and @screenName part of the retweet tweets
	 * @param tweetPlainText
	 * @return
	 */
	private String getRetweetTweet(String tweetPlainText) {
		return tweetPlainText.substring(tweetPlainText.indexOf(":")+1);
	}
	
	/**
	 * Deal with the ' and /n in the plain text, so parseTweetContent method in the twitter.js
	 * can get the proper parameter
	 * @param plainText
	 * @return
	 */
	private String refrainPlainText(String plainText) {
		return plainText.replace("\'", "\\'").replace("\n", "\\n");
	}
}
