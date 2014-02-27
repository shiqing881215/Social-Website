package configuration;

/**
 * Logging Util used by log4j
 * @author shiqing
 *
 */
public class LoggingUtil {
	private static LoggingUtil logginUtil;
	private static final String LOGGING_XML = "/Users/shiqing/Documents/workspace_jee/BWeb/WEB-INF/log4jconfig.xml";
	
	private LoggingUtil() {}
	
	public static LoggingUtil get() {
		if (logginUtil == null) {
			synchronized (LoggingUtil.class) {
				if (logginUtil == null) {
					logginUtil = new LoggingUtil();
				}
			}
		}
		return logginUtil;
	}

	public String getLoggingXml() {
		return LOGGING_XML;
	}
}
