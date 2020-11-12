package com.jesperapps.schoolmanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OneTimePassword {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer otpId;
	public Integer token;
	
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId" )
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "applicationId")
	private Application application;
	
	public Integer getOtpId() {
		return otpId;
	}
	public void setOtpId(Integer otpId) {
		this.otpId = otpId;
	}
	public Integer getToken() {
		return token;
	}
	public void setToken(Integer token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	
	public OneTimePassword() {
		
	}
	
	public OneTimePassword(Integer token,User user) {
		this.token=token;
		this.user=user;
		
		
	}
	
	

}
