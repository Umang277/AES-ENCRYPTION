package com.security.exception;

public class NullException extends RuntimeException {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "NullException [message=" + message + "]";
	}

	public NullException(String message) {
		super();
		this.message = message;
	}

}
