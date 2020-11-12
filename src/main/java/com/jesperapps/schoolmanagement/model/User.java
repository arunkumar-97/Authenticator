package com.jesperapps.schoolmanagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jesperapps.schoolmanagement.jsondatamodel.UserJSON;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Column(unique = true)
	private String email;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "user")
	private List<OneTimePassword> oneTimePassword;
	
	public User() {
		
	}
	
	public User(UserJSON requestUser) {
	
	email=requestUser.getEmail();
	password=requestUser.getPassword();
		
	}
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<OneTimePassword> getOneTimePassword() {
		return oneTimePassword;
	}

	public void setOneTimePassword(List<OneTimePassword> oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}

	
	public OneTimePassword getOtpExistingInDB(Application app) {
		for(OneTimePassword otpFromList : this.getOneTimePassword()) {
			if(otpFromList.getApplication().getApplicatioName() == app.getApplicatioName()) {
				return otpFromList;
			}
		}
		return null;
		
	}
	
	public void addOtpToList(OneTimePassword otp) {
		if(this.oneTimePassword == null) {
			this.oneTimePassword = new ArrayList<>();
		}
		this.oneTimePassword.add(otp);
	}

	
	
	
	
	
	
}
