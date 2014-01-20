package Util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Helper class to handle sending HTTP GET/POST request in java
 * Refer to <a>http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/</a>
 * 
 * @author shiqing
 *
 */
public class HttpClient {
	private static final String USER_AGENT = "Mozilla/5.0";
	
	/**
	 * Do a GET to the server and listen the response back
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String sendGet(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
		return response.toString();
	}
	
	/**
	 * Do a POST to the server and listen the response back
	 * @param url - include the form value in the url, refer to mkyong link
	 * @return
	 * @throws Exception
	 */
	public static String sendPost(String url) throws Exception {
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.flush();
		wr.close();
 
		// Read response status code
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		// Read response body value
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		System.out.println(response.toString());
		return response.toString();
	}
}
