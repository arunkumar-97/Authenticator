package com.jesperapps.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jesperapps.schoolmanagement.message.Response;
import com.jesperapps.schoolmanagement.message.UserWithApplicationResponse;
import com.jesperapps.schoolmanagement.model.Application;
import com.jesperapps.schoolmanagement.model.User;
import com.jesperapps.schoolmanagement.repository.service.ApplicationService;
import com.jesperapps.schoolmanagement.repository.service.OneTimePasswordService;
import com.jesperapps.schoolmanagement.repository.service.UserService;

@RestController
@RequestMapping("/otp")
public class OneTimePasswordController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private OneTimePasswordService oneTimePasswordService;
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/generate")
	public ResponseEntity generateOTP(@RequestBody UserWithApplicationResponse userRequest) {
		User requestUser = userService.findByUserEmail(userRequest.getUser().getEmail());
		if(requestUser != null) {
			Application requestApplication = applicationService.findByApplicationName(userRequest.getApplication().getApplicationName());
			if (requestApplication != null) {
				return ResponseEntity.status(HttpStatus.OK).body(oneTimePasswordService.generateOtp(requestUser, requestApplication));
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(409,"Application not found"));
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(409, "User not found"));
		}
	}
	

	
	

}
