package com.security.exception;

public class InvalidLoginException extends RuntimeException {
	
	private String message;

	public InvalidLoginException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidLoginException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
