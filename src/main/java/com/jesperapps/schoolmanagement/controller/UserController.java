package com.jesperapps.schoolmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.jesperapps.schoolmanagement.jsondatamodel.UserJSON;
import com.jesperapps.schoolmanagement.message.OtpRequest;

import com.jesperapps.schoolmanagement.message.Response;
import com.jesperapps.schoolmanagement.message.UserResponse;
import com.jesperapps.schoolmanagement.repository.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user")
	public UserResponse createUser(@RequestBody List<UserJSON> userRequest) {
	return userService.createUser(userRequest);
	}
	

	@PostMapping("/check-otp")
	public List<Response> checkOTP(@RequestBody List<OtpRequest> emailOtpRequest){
		List<Response> responseList = userService.validateOTP(emailOtpRequest);
		return responseList;
	}
	

}
