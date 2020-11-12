package com.jesperapps.schoolmanagement.repository.service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jesperapps.schoolmanagement.jsondatamodel.UserJSON;
import com.jesperapps.schoolmanagement.message.OtpRequest;
import com.jesperapps.schoolmanagement.message.Response;
import com.jesperapps.schoolmanagement.message.UserResponse;
import com.jesperapps.schoolmanagement.model.Application;
import com.jesperapps.schoolmanagement.model.User;
import com.jesperapps.schoolmanagement.repository.UserRepository;

@Service
public class UserServiceImplementationService implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OneTimePasswordService oneTimePasswordService;
	
	@Autowired
	private ApplicationImplementationService applicationImplementationService;
	
	
	
	
	@Override
	public UserResponse createUser(List<UserJSON> userRequest) {
		UserResponse response=new UserResponse();
		for( UserJSON user:userRequest) {
			try {
				User newUser=new User(user);
				this.saveUser(newUser);
			}catch(HibernateException exception) {
				response.setStatuscode(409);
				response.setDescription("Email Already Exists");
				return response;
				
			}
		}
		response.setUsers(userRequest);
				return response;
	}




	@Override
	public void saveUser(User user) {
		userRepository.save(user);
		
	}




	@Override
	public User findByUserEmail(String userEmail) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(userEmail);
	}




	@Override
	public List<Response> validateOTP(List<OtpRequest> emailOtpRequest) {
List<Response> responseList = new ArrayList<>();
		
		for(OtpRequest request : emailOtpRequest) {
			Response response = new Response(400, "Bad request");
			User requestUser = this.findByUserEmail(request.getUser().getEmail());
			Application requestApplication = this.applicationImplementationService.findByApplicationName(request.getApplication().getApplicationName());
			if(requestUser != null) {
				if(requestApplication != null) {
				if(oneTimePasswordService.checkOTP(requestUser, requestApplication, request.getOtp().getToken())) {
					response.setStatuscode(200);
					response.setDescription("Otp Matched");
				}else {
					response.setStatuscode(400);
					response.setDescription("Otp Mismatch");
				} }
				else {
					response.setStatuscode(409);
					response.setDescription("No Such Application Found");
				}
			}else {
				response.setStatuscode(409);
				response.setDescription("No user found");
			}
			responseList.add(response);
		}
		
		return responseList;
	}

	
}
