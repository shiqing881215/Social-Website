package controller.twitter;

import Util.BaseUtil;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Twitter Stuff Util Class
 * Singleton pattern, only one twitter util instance
 * 
 * @author shiqing
 *
 */
public class TwitterUtil extends BaseUtil {
	private static TwitterUtil twitterUtil;
	private static final String CONSUMER_KEY = "twitter.consumerKey";
	private static final String CONSUMER_SECRET = "twitter.consumerSecret";
	
	private TwitterUtil() {
		// do nothing, private constructor
	}
	
	public static TwitterUtil get() {
		if (twitterUtil == null) {
			// If two threads run at the same time
			// http://en.wikipedia.org/wiki/Singleton_pattern#Example
			synchronized (TwitterUtil.class) {
				if (twitterUtil == null) {
					twitterUtil = new TwitterUtil();
				}
			}
		}
		return twitterUtil;
	}
	
	@Override
	protected String getKey() {
		return CONSUMER_KEY;
	}

	@Override
	protected String getSecret() {
		return CONSUMER_SECRET;
	}
	
	/**
	 * Get the single twitter instance
	 * All the remaining twitter api calls should be reuse this instance
	 * If fail return null.
	 * @return
	 */
	public Twitter getTwitterInstance() {
		Pair<String> keyAndSecret = getKeyAndSecretSetting();
		if (keyAndSecret != null) {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthConsumerKey(keyAndSecret.getKey())
			  .setOAuthConsumerSecret(keyAndSecret.getSecret());
			
			TwitterFactory tf = new TwitterFactory(cb.build());
			return tf.getInstance();
		} else {
			return null;
		}
	}
}
