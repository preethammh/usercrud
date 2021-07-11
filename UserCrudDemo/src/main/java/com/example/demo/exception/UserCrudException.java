package com.example.demo.exception;

public class UserCrudException extends RuntimeException {

	/**
	 * Serial version Id
	 */
	private static final long serialVersionUID = 1L;
	
	// error message
	private String errorMessage;
	
	// create a default constructor
	public UserCrudException() {
		
	}
	
	public UserCrudException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}


	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
