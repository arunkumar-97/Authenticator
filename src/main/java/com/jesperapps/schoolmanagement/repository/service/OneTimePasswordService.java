package com.jesperapps.schoolmanagement.repository.service;

//import com.jesperapps.schoolmanagement.api.model.ConfirmationToken;
import com.jesperapps.schoolmanagement.jsondatamodel.OneTimePasswordJSON;
import com.jesperapps.schoolmanagement.model.Application;
import com.jesperapps.schoolmanagement.model.User;

public interface OneTimePasswordService {
	
	public OneTimePasswordJSON generateOtp(User requestUser, Application requestApplication);
	
	public boolean checkOTP(User requestUser, Application requestApplication, Integer otp);

}
