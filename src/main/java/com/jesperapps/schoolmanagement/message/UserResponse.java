package com.jesperapps.schoolmanagement.message;

import java.util.List;

import com.jesperapps.schoolmanagement.jsondatamodel.UserJSON;

public class UserResponse extends BaseResponse {
	
	
	public UserResponse() {
		super();
	}
	
	public UserResponse(Integer statusCode, String description) {
		super(statusCode, description);
	}

	
	private List<UserJSON> users;

	public List<UserJSON> getUsers() {
		return users;
	}

	public void setUsers(List<UserJSON> users) {
		this.users = users;
	}
	
	

}
