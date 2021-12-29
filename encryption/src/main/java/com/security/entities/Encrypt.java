package com.security.entities;

import org.springframework.stereotype.Component;

@Component
public class Encrypt {
	
	private String encryptString;

	public String getEncryptString() {
		return encryptString;
	}

	public void setEncryptString(String encryptString) {
		this.encryptString = encryptString;
	}

	@Override
	public String toString() {
		return "Encrypt [encryptString=" + encryptString + "]";
	}

	public Encrypt(String encryptString) {
		super();
		this.encryptString = encryptString;
	}

	public Encrypt() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
