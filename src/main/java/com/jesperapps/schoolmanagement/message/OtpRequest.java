package com.jesperapps.schoolmanagement.message;

import com.jesperapps.schoolmanagement.jsondatamodel.ApplicationJSON;
import com.jesperapps.schoolmanagement.jsondatamodel.OneTimePasswordJSON;
import com.jesperapps.schoolmanagement.jsondatamodel.UserJSON;

public class OtpRequest {

	
	private UserJSON user;
	private OneTimePasswordJSON otp;
	private ApplicationJSON application;
	public UserJSON getUser() {
		return user;
	}
	public void setUser(UserJSON user) {
		this.user = user;
	}
	public OneTimePasswordJSON getOtp() {
		return otp;
	}
	public void setOtp(OneTimePasswordJSON otp) {
		this.otp = otp;
	}
	public ApplicationJSON getApplication() {
		return application;
	}
	public void setApplication(ApplicationJSON application) {
		this.application = application;
	}
	
	
	
}
