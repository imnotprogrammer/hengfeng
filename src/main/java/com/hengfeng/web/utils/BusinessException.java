package com.hengfeng.web.utils;

public class BusinessException extends Exception {

	private Exception exception;
	
	private ApiResponse response;
	
	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public ApiResponse getResponse() {
		return response;
	}

	public void setResponse(ApiResponse response) {
		this.response = response;
	}

	BusinessException(Exception ex, ApiResponse response)
	{
		this.exception = ex;
		this.response = response;
	}
	
}
