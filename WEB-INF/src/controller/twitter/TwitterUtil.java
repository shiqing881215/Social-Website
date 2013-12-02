package controller.twitter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Twitter Stuff Util Class
 * @author shiqing
 *
 */
public class TwitterUtil {
	private static final String PROPERTIES_FILE_PATH = "/Users/shiqing/Documents/workspace_jee/BWeb/WEB-INF/twitter4j.properties";
	private static final String CONSUMER_KEY = "oauth.consumerKey";
	private static final String CONSUMER_SECRET = "oauth.consumerSecret";
	
	/**
	 * Get the single twitter instance
	 * All the remaining twitter api calls should be reuse this instance
	 * If fail return null.
	 * @return
	 */
	public static Twitter getTwitterInstance() {
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
	
	/**
	 * Get the consumer key and consumer secret from safe property file
	 * Any steps fail return null.
	 * @return
	 */
	public static Pair<String> getKeyAndSecretSetting() {
		File file = new File(PROPERTIES_FILE_PATH);
        Properties prop = new Properties();
        InputStream is = null;
        OutputStream os = null;
        try {
            if (file.exists()) {
                is = new FileInputStream(file);
                prop.load(is);
            } else {
            	return null;
            }
            
            if (null == prop.getProperty(CONSUMER_KEY)
                    || null == prop.getProperty(CONSUMER_SECRET)) {
                // consumer key/secret are not set in twitter4j.properties
                return null;
            } else {
            	return new Pair<String>(prop.getProperty(CONSUMER_KEY),prop.getProperty(CONSUMER_SECRET));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ignore) {
                	return null;
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ignore) {
                	return null;
                }
            }
        }
	}
	
	/**
	 * Pair structure for key and secret
	 * @author shiqing
	 *
	 * @param <T>
	 */
	public static class Pair<T> {
		private T key;
		private T secret;
		
		public Pair(T key, T secret) {
			super();
			this.key = key;
			this.secret = secret;
		}
		
		public T getKey() {
			return key;
		}
		public void setKey(T key) {
			this.key = key;
		}
		public T getSecret() {
			return secret;
		}
		public void setSecret(T secret) {
			this.secret = secret;
		}
	}
}
