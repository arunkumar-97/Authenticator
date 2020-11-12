package com.jesperapps.schoolmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Application {

	@Id
	private int applicationId;
	private String applicationName;
	@OneToOne(mappedBy = "application")
	private OneTimePassword oneTimePassword;
	
	
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public OneTimePassword getOneTimePassword() {
		return oneTimePassword;
	}
	
	public void setOneTimePassword(OneTimePassword oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplicatioName() {
		return applicationName;
	}
	public void setApplicatioName(String applicationName) {
		this.applicationName = applicationName;
		
	}
	public boolean equals(Application anotherApplication) {
		return this.getApplicationId() == anotherApplication.getApplicationId();
	}
	
	public Application() {
		
	}
	
	public Application(int applicationId,String applicationName) {
		this.applicationId=applicationId;
		this.applicationName=applicationName;
	}
	
	
	
}
