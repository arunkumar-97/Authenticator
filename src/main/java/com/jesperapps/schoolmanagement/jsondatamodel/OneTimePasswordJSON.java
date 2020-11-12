package com.jesperapps.schoolmanagement.jsondatamodel;

import com.jesperapps.schoolmanagement.model.OneTimePassword;

public class OneTimePasswordJSON {

	public Integer otpId;
	public Integer token;
	
	public OneTimePasswordJSON() {
		
	}
	
	public OneTimePasswordJSON(OneTimePassword otp) {
		this.setOtpId(otp.getOtpId());
		this.setToken(otp.getToken());
	}

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
	
	
}
