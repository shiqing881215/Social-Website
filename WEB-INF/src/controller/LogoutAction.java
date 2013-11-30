package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class LogoutAction extends Action{
	
	public LogoutAction(Model model){}

	@Override
	public String getActionName() {
		return "logout.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		
//		System.out.println( "Hello World!" );
//		
//		ConfigurationBuilder cb = new ConfigurationBuilder();
//		cb.setDebugEnabled(true)
//		  .setOAuthConsumerKey("xg1MDx9GCCRZZxTqmq2HA")
//		  .setOAuthConsumerSecret("wDDnowoQbjnhpiqzlyrEdV4otHJuvQJ15zwqrlvg")
//		  .setOAuthAccessToken("490701049-LdNaQjQrsBIpBQOM4RKrbHVSeEOpH0tJB5zHQHCl")
//		  .setOAuthAccessTokenSecret("tB6nPzBZwf7SsIcpRBu8dHysuWJ4McxPyJiOXuZShKA");
//		
//		TwitterFactory tf = new TwitterFactory(cb.build());
//		Twitter twitter = tf.getInstance();
//        List<Status> statuses = null;
//		try {
//			statuses = twitter.getHomeTimeline();
//		} catch (TwitterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println("Showing home timeline.");
//        for (Status status : statuses) {
//            System.out.println(status.getUser().getName() + ":" +
//                               status.getText());
//        }
		
/*		
		
        try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
    		cb.setDebugEnabled(true)
    		  .setOAuthConsumerKey("xg1MDx9GCCRZZxTqmq2HA")
    		  .setOAuthConsumerSecret("wDDnowoQbjnhpiqzlyrEdV4otHJuvQJ15zwqrlvg");
    		
    		TwitterFactory tf = new TwitterFactory(cb.build());
    		Twitter twitter = tf.getInstance();
    		
    		
			RequestToken requestToken = twitter.getOAuthRequestToken("http://www.google.com");
			
			System.out.println("Got request token.");
            System.out.println("Request token: " + requestToken.getToken());
            System.out.println("Request token secret: " + requestToken.getTokenSecret());
            AccessToken accessToken = null;
            
            System.out.println("Open the following URL and grant access to your account:");
            System.out.println(requestToken.getAuthorizationURL());
            try {
                Desktop.getDesktop().browse(new URI(requestToken.getAuthorizationURL()));
            } catch (UnsupportedOperationException ignore) {
            } catch (IOException ignore) {
            } catch (URISyntaxException e) {
                throw new AssertionError(e);
            }
            System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
//            String pin = br.readLine();
//            try {
//                if (pin.length() > 0) {
//                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
//                } else {
                    accessToken = twitter.getOAuthAccessToken(requestToken);
//                }
//            } catch (TwitterException te) {
//                if (401 == te.getStatusCode()) {
//                    System.out.println("Unable to get the access token.");
//                } else {
//                    te.printStackTrace();
//                }
//            }
                    System.out.println("Got access token.");
                    System.out.println("Access token: " + accessToken.getToken());
                    System.out.println("Access token secret: " + accessToken.getTokenSecret());
			
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
*/		
		
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
    		cb.setDebugEnabled(true)
    		  .setOAuthConsumerKey("xg1MDx9GCCRZZxTqmq2HA")
    		  .setOAuthConsumerSecret("wDDnowoQbjnhpiqzlyrEdV4otHJuvQJ15zwqrlvg")
    		  .setOAuthAccessToken("490701049-LdNaQjQrsBIpBQOM4RKrbHVSeEOpH0tJB5zHQHCl")
    		  .setOAuthAccessTokenSecret("tB6nPzBZwf7SsIcpRBu8dHysuWJ4McxPyJiOXuZShKA");
    		
    		TwitterFactory tf = new TwitterFactory(cb.build());
    		Twitter twitter = tf.getInstance();
    		
            int page = 1;
            ResponseList<User> users;
            do {
                users = twitter.searchUsers("ravi", page);
                for (User user : users) {
                    if (user.getStatus() != null) {
                        System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
                    } else {
                        // the user is protected
                        System.out.println("@" + user.getScreenName());
                    }
                }
                page++;
            } while (users.size() != 0 && page < 50);
            System.out.println("done.");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search users: " + te.getMessage());
            System.exit(-1);
        }
		
		
		
		
		HttpSession session = request.getSession(false);
		session.setAttribute("user", null);
		return "login.html";
	};
}
