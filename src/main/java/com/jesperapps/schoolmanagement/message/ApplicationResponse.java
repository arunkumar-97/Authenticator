package com.jesperapps.schoolmanagement.message;

import com.jesperapps.schoolmanagement.model.Application;

public class ApplicationResponse {
	
	private int applicationId;
	private String applicationName;
	
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
	public ApplicationResponse() {
		
	}
	
	
	public ApplicationResponse(int applicationId, String applicationName) {
		
		this.applicationId = applicationId;
		this.applicationName = applicationName;
	}
	
	public ApplicationResponse(Application application) {
		this.applicationId=application.getApplicationId();
		this.applicationName=application.getApplicatioName();
	}
	

}
