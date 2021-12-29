package com.security.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.security.entities.Encrypt;
import com.security.entities.User;
import com.security.response.ResponseBody;
import com.security.response.ResponseEncrypt;
import com.security.service.EncryptService;

@RestController
public class EncryptionController {

	@Value("${SECRET_KEY}")
	private String SECRET_KEY;
	@Autowired
	private EncryptService service;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/encrypt")
	public ResponseEncrypt encrypt(@RequestBody User user) {
		try {
			LOGGER.info("CAME TO HOME FUNCTION IN CONTROLLER");
			return service.encryptService(user);
		} catch (Exception e) {
			return new ResponseEncrypt(401, e.getMessage());
		}
	}

	@PostMapping("/decrypt")
	public ResponseBody decrypt(@RequestBody String encryptString)
			throws JsonMappingException, JsonProcessingException {
		try {
			LOGGER.info("CAME TO VALIDATE FUNCTION IN CONTROLLER");
			return service.decryptService(encryptString);
		} catch (Exception e) {
			return new ResponseBody(401, e.getMessage());
		}
	}

}
