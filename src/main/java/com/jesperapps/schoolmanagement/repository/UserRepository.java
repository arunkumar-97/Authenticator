package com.jesperapps.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.jesperapps.schoolmanagement.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUserId(Integer userId);
	
	User findByEmail(String email);
}
