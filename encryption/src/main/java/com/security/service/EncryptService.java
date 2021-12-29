package com.security.service;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.entities.User;
import com.security.exception.InvalidLoginException;
import com.security.exception.NullException;
import com.security.response.ResponseBody;
import com.security.response.ResponseEncrypt;
import com.security.util.Aes;

@Service
public class EncryptService {
	@Value("${name}")
	private String name;
	@Value("${email}")
	private String email;
	@Value("${password}")
	private String password;
	@Autowired
	private Aes aes;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public ResponseEncrypt encryptService(User user) {
		try {
			LOGGER.info("CAME TO HOMESERVICE FUNCTION IN ENCRYPTSERVICE CLASS");

			JSONObject object = new JSONObject(user);// model to json object
			String jsonString = object.toString();
			System.out.println(jsonString);
			String encryptString = aes.encrypt(jsonString);
			System.out.println(encryptString);
			String decryptString = aes.decrypt(encryptString);
			System.out.println(decryptString);

			ObjectMapper om = new ObjectMapper();
			User user2 = om.readValue(jsonString, User.class);
			System.out.println(user2);
			return new ResponseEncrypt(200, "SUCCESSFUL", encryptString);
		} catch (JsonMappingException e) {
			return new ResponseEncrypt(401, e.getMessage());
		} catch (JsonProcessingException e) {

			return new ResponseEncrypt(401, e.getMessage());
		}
	}

	public void matchCredentials(User user) {
		String email1 = user.getEmail();
		String password1 = user.getPassword();
		String name1 = user.getName();

		if (name1 == "" || email1 == "" || password1 == "") {
			throw new NullException("this credentials can not be null");
		} else if (name1.equalsIgnoreCase(name) == false) {

			throw new InvalidLoginException("Invalid Login Credentials");
		} else if (password1.equalsIgnoreCase(password) == false) {

			throw new InvalidLoginException("Invalid Login Credentials");
		}

	}

	public ResponseBody decryptService(String encryptString) throws JsonMappingException, JsonProcessingException {
		try {
			String decryptString = aes.decrypt(encryptString);
			LOGGER.info("DECRYPT");
			if (decryptString == null || decryptString.length() == 0) {
				return new ResponseBody(401, "DECRYPT STRING IS NULL");
			}
			JSONObject json = new JSONObject(decryptString);// CONVERT STRING TO JSON OBJECT
			ObjectMapper om = new ObjectMapper();// CONVERT STRING TO MODEL CLASS
			User user2 = om.readValue(decryptString, User.class);
			matchCredentials(user2);
			return new ResponseBody(200, "SUCCESSFULL", user2);
		} catch (InvalidLoginException e) {
			return new ResponseBody(401, e.getMessage());
		}

		catch (Exception e) {
			return new ResponseBody(401, "CAN NOT DECRYPTING");
		}

	}
}
