package com.jesperapps.schoolmanagement.message;

public class Response extends BaseResponse {

	public Response() {
		super();
	}
	
	public Response(Integer statusCode, String description) {
		super(statusCode, description);
	}
}
