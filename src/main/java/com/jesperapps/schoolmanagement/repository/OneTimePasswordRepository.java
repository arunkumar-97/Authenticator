package com.jesperapps.schoolmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.jesperapps.schoolmanagement.model.OneTimePassword;

public interface OneTimePasswordRepository extends CrudRepository<OneTimePassword, Integer> {
	OneTimePassword findByToken(Integer token);
}
