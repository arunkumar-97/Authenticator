package com.jesperapps.schoolmanagement.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.model.Application;
import com.jesperapps.schoolmanagement.repository.ApplicationRepository;

@Service
public class ApplicationImplementationService implements ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Override
	public Application findByApplicationName(String applicationName) {
		// TODO Auto-generated method stub
		return applicationRepository.findByApplicationName(applicationName);
	}

}
