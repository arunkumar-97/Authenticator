 package com.jesperapps.schoolmanagement.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesperapps.schoolmanagement.message.ApplicationResponse;
import com.jesperapps.schoolmanagement.message.BaseResponse;
import com.jesperapps.schoolmanagement.model.Application;
import com.jesperapps.schoolmanagement.repository.ApplicationRepository;
import com.jesperapps.schoolmanagement.utils.Applications;

@RestController
public class ApplicationController {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	
	@PostMapping("/application")
	public BaseResponse createApplication(){
		BaseResponse response= new BaseResponse(200,"Applications Created Successfully") {
			
		};
		Application application1=new Application(1,Applications.SCHOOLMANAGEMENT);
		Application application2=new Application(2,Applications.PROJECTMANAGEMENT);
		Application application3=new Application(3,Applications.EMAILAPPLICATION);
		Application application4=new Application(4,Applications.JESPERAPPSAPPLICATION);
		applicationRepository.save(application1);
		applicationRepository.save(application2 );
		applicationRepository.save(application3);
		applicationRepository.save(application4);
		return response;
		
		
	}
	
	@GetMapping("/application")
	public List<ApplicationResponse> getAllApplications(){
		return applicationRepository.findAll().stream().map(application -> new ApplicationResponse(application)).collect(Collectors.toList());
		
		
	}
	
	
	
	

}
