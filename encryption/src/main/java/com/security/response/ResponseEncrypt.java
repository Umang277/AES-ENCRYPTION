package com.security.response;

public class ResponseEncrypt {
	private int responseCode;
	private String responseMessage;
	private String encryptedString;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getEncryptedString() {
		return encryptedString;
	}

	public void setEncryptedString(String encryptedString) {
		this.encryptedString = encryptedString;
	}

	@Override
	public String toString() {
		return "ResponseEncrypt [responseCode=" + responseCode + ", responseMessage=" + responseMessage
				+ ", encryptedString=" + encryptedString + "]";
	}

	public ResponseEncrypt(int responseCode, String responseMessage, String encryptedString) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.encryptedString = encryptedString;
	}

	public ResponseEncrypt(int responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public ResponseEncrypt() {
		super();
		// TODO Auto-generated constructor stub
	}

}
