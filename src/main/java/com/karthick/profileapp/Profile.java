package com.karthick.profileapp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@Column(name = "profileId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long profileId;
	
	@Column(name = "profileName")
	private String profileName;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "createdDate")
	private Date createdDate;

	public Profile() {
		
	}
	
	public Profile(String profileName, String firstName, String lastName) {
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdDate = new Date();
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

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Date getProfileCreatedDate() {
		return createdDate;
	}

	public void setProfileCreatedDate(Date profileCreatedDate) {
		this.createdDate = profileCreatedDate;
	} 
	
	@Override
	public String toString() {
		return "Profile{" + "id=" + profileId + ", title='" + profileName + '\'' + ", content='" + firstName + '\''
				+ ", content='" + lastName + '\'' + ", content='" + createdDate + '\'' + '}';
	}
}
