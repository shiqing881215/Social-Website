package databean;

import java.util.ArrayList;
import java.util.List;

import com.restfb.types.NamedFacebookType;
import com.restfb.types.User;
import com.restfb.types.User.Education;
import com.restfb.types.User.Work;

/**
 * 
 * @author shiqing
 *
 */
public class FacebookUser {
	private String firstName;
	private String middleName;
	private String lastName;
	private String link;
	private String bio;
	private String quotes;
	private String about;
	private String relationshipStatus;
	private String religion;
	private String website;
	private String birthday;
	private String email;
	private Double timezone;
	private Boolean verified;
	private String gender;
	private String political;
	private String locale;
	private String username;
	
	private NamedFacebookType hometown;
	private NamedFacebookType location;
	private List<Work> work = new ArrayList<Work>();
	private List<Education> education = new ArrayList<Education>();
	  
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getQuotes() {
		return quotes;
	}
	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getTimezone() {
		return timezone;
	}
	public void setTimezone(Double timezone) {
		this.timezone = timezone;
	}
	public Boolean getVerified() {
		return verified;
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPolitical() {
		return political;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public NamedFacebookType getHometown() {
		return hometown;
	}
	public void setHometown(NamedFacebookType hometown) {
		this.hometown = hometown;
	}
	public NamedFacebookType getLocation() {
		return location;
	}
	public void setLocation(NamedFacebookType location) {
		this.location = location;
	}
	public List<Work> getWork() {
		return work;
	}
	public void setWork(List<Work> work) {
		this.work = work;
	}
	public List<Education> getEducation() {
		return education;
	}
	public void setEducation(List<Education> education) {
		this.education = education;
	}
	
	public FacebookUser(User user) { 
		this.firstName  = user.getFirstName();
		this.middleName = user.getMiddleName();
		this.lastName   = user.getLastName();
		this.link       = user.getLink();
		this.bio        = user.getBio();
		this.quotes     = user.getQuotes();
		this.about      = user.getAbout();
		this.relationshipStatus = user.getRelationshipStatus();
		this.religion   = user.getReligion();
		this.website    = user.getWebsite();
		this.birthday   = user.getBirthday();
		this.email      = user.getEmail();
		this.timezone   = user.getTimezone();
		this.verified   = user.getVerified();
		this.gender     = user.getGender();
		this.political  = user.getPolitical();
		this.locale     = user.getLocale();
		this.username   = user.getUsername();
		this.hometown   = user.getHometown();
		this.location   = user.getLocation();
		this.work       = user.getWork();
		this.education  = user.getEducation();
	}
}
