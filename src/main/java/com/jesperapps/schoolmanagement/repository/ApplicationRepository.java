package com.jesperapps.schoolmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jesperapps.schoolmanagement.model.Application;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {

	Application findByApplicationName(String applicationName);
	
	List<Application> findAll();
}
