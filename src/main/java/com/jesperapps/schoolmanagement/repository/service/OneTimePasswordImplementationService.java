package com.jesperapps.schoolmanagement.repository.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jesperapps.schoolmanagement.jsondatamodel.OneTimePasswordJSON;
import com.jesperapps.schoolmanagement.model.Application;
import com.jesperapps.schoolmanagement.model.OneTimePassword;
import com.jesperapps.schoolmanagement.model.User;

import com.jesperapps.schoolmanagement.repository.service.UserService;

@Service
public class OneTimePasswordImplementationService implements OneTimePasswordService {

	private static final String FROM_ADDRESS = "arun.thril@gmail.com";
	
	private JavaMailSender mailSender;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public OneTimePasswordImplementationService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	private final Integer OTP_LENGTH = 6;
	
	private String generateRandomOTP() {
		String oneTimePassword = "";
		Random randomGenerator = new Random();
		for(int i=0;i<OTP_LENGTH;i++) {
			oneTimePassword += randomGenerator.nextInt(10);
		}
		return oneTimePassword;
	}
	
	private boolean sendEmail(User requestUser, String otp) {
		try {
			SimpleMailMessage otpMail = new SimpleMailMessage();
			otpMail.setTo(requestUser.getEmail());
			otpMail.setFrom(FROM_ADDRESS);
			otpMail.setText("Hi "+requestUser.getEmail()+", The One Time Password for your login request is "+otp);
			this.mailSender.send(otpMail);
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		return true;
	}

	
	@Override
	public OneTimePasswordJSON generateOtp(User requestUser, Application requestApplication) {
		OneTimePassword newOtp = requestUser.getOtpExistingInDB(requestApplication);
		if(newOtp == null) {
			newOtp = new OneTimePassword();
			newOtp.setApplication(requestApplication);
			newOtp.setUser(requestUser);
			requestUser.addOtpToList(newOtp);
		}
		newOtp.setToken(Integer.parseInt(this.generateRandomOTP()));
		if(this.sendEmail(requestUser, newOtp.getToken().toString())) {
			userService.saveUser(requestUser);
			return new OneTimePasswordJSON(newOtp);	
		}
		else{
			return null;
		}
	}
	
	@Override
	public boolean checkOTP(User requestUser, Application requestApplication, Integer otp) {
		List<OneTimePassword> usersOTPList = requestUser.getOneTimePassword();
		if(usersOTPList != null) {
			for(OneTimePassword eachOtp : usersOTPList) {
				if(eachOtp.getApplication().equals(requestApplication)) {
					if(eachOtp.getToken().equals(otp)) {
						return true;
					}else {
						return false;
					}
				}
			}
		}
		return false;
	}

	

}
