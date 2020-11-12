package com.jesperapps.schoolmanagement.repository.service;

import com.jesperapps.schoolmanagement.model.Application;

public interface ApplicationService {
	Application findByApplicationName(String applicationName);
}
