package com.jesperapps.schoolmanagement.repository.service;

import java.util.List;

import com.jesperapps.schoolmanagement.jsondatamodel.UserJSON;
import com.jesperapps.schoolmanagement.message.OtpRequest;
import com.jesperapps.schoolmanagement.message.Response;
import com.jesperapps.schoolmanagement.message.UserResponse;
import com.jesperapps.schoolmanagement.model.User;

public interface UserService {

	UserResponse createUser(List<UserJSON> userRequest);

	void saveUser(User user);
	
	User findByUserEmail(String userEmail);

	List<Response> validateOTP(List<OtpRequest> emailOtpRequest);
}
