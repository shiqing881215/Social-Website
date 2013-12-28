package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Base util class to read the app setting value from the property file
 * 
 * @author shiqing
 *
 */
public abstract class BaseUtil {
	private static final String PROPERTIES_FILE_PATH = "/Users/shiqing/Documents/workspace_jee/BWeb/WEB-INF/user.properties";
	
	protected abstract String getKey();
	
	protected abstract String getSecret();
	
	/**
	 * Get the consumer key and consumer secret from safe property file
	 * Any steps fail return null.
	 * @return
	 */
	public Pair<String> getKeyAndSecretSetting() {
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
            
            if (null == prop.getProperty(getKey())
                    || null == prop.getProperty(getSecret())) {
                // consumer key/secret are not set in twitter4j.properties
                return null;
            } else {
            	return new Pair<String>(prop.getProperty(getKey()),prop.getProperty(getSecret()));
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

