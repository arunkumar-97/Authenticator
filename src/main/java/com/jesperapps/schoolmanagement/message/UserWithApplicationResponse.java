package com.jesperapps.schoolmanagement.message;

import com.jesperapps.schoolmanagement.jsondatamodel.ApplicationJSON;
import com.jesperapps.schoolmanagement.jsondatamodel.UserJSON;

public class UserWithApplicationResponse {
	
	
	private UserJSON user;
	
	private ApplicationJSON application;


	public UserJSON getUser() {
		return user;
	}

	public void setUser(UserJSON user) {
		this.user = user;
	}

	public ApplicationJSON getApplication() {
		return application;
	}

	public void setApplication(ApplicationJSON application) {
		this.application = application;
	}
	
	
}
