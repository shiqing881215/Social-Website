package rest.foursquare;

import java.util.List;

/**
 * Class represent the user in FourSquare.
 * 
 * @author shiqing
 *
 */
// TODO  Need to full mapped to be consumed by Gson
public class FourSquareUser {
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	private Photo photo;
	private String homeCity;
	private String bio;
	private Contact contact;
	private List<FourSquareUser> friends;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<FourSquareUser> getFriends() {
		return friends;
	}

	public void setFriends(List<FourSquareUser> friends) {
		this.friends = friends;
	}

	/**
	 * Data model for photo attribute in user 
	 * photo: {
	 *		prefix: "https://irs1.4sqi.net/img/user/"
	 *		suffix: "/76678922-XEKUNTA0QPNCDE23.jpg"
	 * }
	 * 
	 * @author shiqing
	 *
	 */
	public static class Photo {
		private String prefix;
		private String suffix;
		
		public Photo(String prefix, String suffix) {
			this.prefix = prefix;
			this.suffix = suffix;
		}

		public String getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}

		public String getSuffix() {
			return suffix;
		}

		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}
	}
	
	/**
	 * Data model for contact attribute in user
	 * contact: {
	 *		email: "shiqing881215@gmail.com"
	 *		facebook: "100002848664051"
	 * }
	 * 
	 * @author shiqing
	 *
	 */
	public static class Contact {
		private String email;
		private String facebook;
		
		public Contact(String email, String facebook) {
			this.email = email;
			this.facebook = facebook;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFacebook() {
			return facebook;
		}

		public void setFacebook(String facebook) {
			this.facebook = facebook;
		}
	}
	
	/**
	 * Data model for badge
	 * @author shiqing
	 *
	 */
	public static class Badge {
		// TODO
	}
}
