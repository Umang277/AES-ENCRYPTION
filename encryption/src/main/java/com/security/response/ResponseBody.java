package com.security.response;

import org.springframework.stereotype.Component;

import com.security.entities.User;

@Component
public class ResponseBody {
	private int ResponserCode;
	private String ResponseMessage;
	private User user;

	public ResponseBody(int responserCode, String responseMessage) {
		super();
		ResponserCode = responserCode;
		ResponseMessage = responseMessage;
	}

	public ResponseBody(int responserCode, String responseMessage, User user) {
		super();
		ResponserCode = responserCode;
		ResponseMessage = responseMessage;
		this.user = user;
	}

	@Override
	public String toString() {
		return "ResponseBody [ResponserCode=" + ResponserCode + ", ResponseMessage=" + ResponseMessage + ", user="
				+ user + "]";
	}

	public int getResponserCode() {
		return ResponserCode;
	}

	public void setResponserCode(int responserCode) {
		ResponserCode = responserCode;
	}

	public String getResponseMessage() {
		return ResponseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		ResponseMessage = responseMessage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ResponseBody() {
		super();
		// TODO Auto-generated constructor stub
	}

}
