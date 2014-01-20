package rest.linkedin;

import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.google.api.client.util.Lists;

import controller.linkedin.LinkedInUtil;

/**
 * XML parser responsible for the XML response get back from LinkedIn
 * 
 * @author shiqing
 *
 */
public class LinkedInXMLParser {
	
	/**
	 * Extract <a> LinkedInUser </a> from the response XML file.
	 * @param response
	 * @return
	 */
	public static LinkedInUser extractLoginUserInfo(String response) {
		Document responseXML;
		try {
			responseXML = loadXMLFromString(response);
			String firstname = responseXML.getElementsByTagName("first-name").item(0).getTextContent();
			String lastname = responseXML.getElementsByTagName("last-name").item(0).getTextContent();
			String headline = responseXML.getElementsByTagName("headline").item(0).getTextContent();
			String picUrl = responseXML.getElementsByTagName("picture-url").item(0).getTextContent();
			String url = responseXML.getElementsByTagName("public-profile-url").item(0).getTextContent();
			
			return new LinkedInUser(firstname, lastname, headline, picUrl, url);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Extract the first CONNECTION_LIMIT connection from the login user.
	 * @param response
	 * @return
	 */
	public static List<LinkedInUser> extractLoginUserConnections(String response) {
		Document responseXML;
		try {
			response = connectionPreHook(response); System.out.println(response);
			responseXML = loadXMLFromString(response);
			NodeList firstnames = responseXML.getElementsByTagName("first-name");
			NodeList lastnames = responseXML.getElementsByTagName("last-name");
			NodeList headlines = responseXML.getElementsByTagName("headline");
			NodeList picUrls = responseXML.getElementsByTagName("picture-url");
			
			List<LinkedInUser> connections = Lists.newArrayList();
			LinkedInUser linkedInUser;
			for (int i = 0; i < Math.min(LinkedInUtil.CONNECTION_LIMIT, firstnames.getLength()); i++) {
				if (firstnames.item(i).getTextContent().equals("private")) {
					continue;
				}
				linkedInUser = new LinkedInUser(firstnames.item(i).getTextContent(), 
												lastnames.item(i).getTextContent(), 
												headlines.item(i).getTextContent(), 
												picUrls.item(i).getTextContent());
				connections.add(linkedInUser);
			}
			
			return connections;
		} catch (Exception e) {
			//TODO log
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Load the xml string file
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static Document loadXMLFromString(String xml) throws Exception {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(xml));
	    return builder.parse(is);
	}
	
	/**
	 * Pre hook for the connection response XML.
	 * Reduce the size to <a>CONNECTION_LIMIT</a>.
	 * Also remove all private accounts.
	 * @param responseXML
	 * @return
	 */
	public static String connectionPreHook(String responseXML) {
		String[] people = responseXML.split("</person>");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < Math.min(LinkedInUtil.CONNECTION_LIMIT, people.length); i++) {
			if (people[i].contains("<first-name>private</first-name>")) continue;
			sb.append(people[i]);
			sb.append("</person>");
		}
		sb.append("</connections>");
		return sb.toString();
	}
}
