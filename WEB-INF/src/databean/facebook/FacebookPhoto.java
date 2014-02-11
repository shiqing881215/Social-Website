package databean.facebook;

import java.util.Map;

import com.google.gson.Gson;
import com.restfb.json.JsonObject;

/**
 * Facebook tagged photo wrapper
 * @author shiqing
 *
 */
public class FacebookPhoto {
	private String source;
	private String name;
	private String link;
	private FromUser from;
	
	public FacebookPhoto(JsonObject json) {
		this.source = json.getString("source");
		// In case, no name attribute
		try {
			this.name = json.getString("name");
		} catch (Exception e) {
			
		}
		this.link = json.getString("link");
		this.from = new FromUser(json.getString("from"));
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
    public FromUser getFrom() {
		return from;
	}
	public void setFrom(FromUser from) {
		this.from = from;
	}

	public static class FromUser {
		private String name;
		private String id;
		
		public FromUser(String jsonString) {
			Gson gson = new Gson();
			@SuppressWarnings("unchecked")
			Map<String, String> map = gson.fromJson(jsonString, Map.class);	
			
			this.name = map.get("name");
			this.id = map.get("id");
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}
}
