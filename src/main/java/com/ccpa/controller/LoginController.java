package com.ccpa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccpa.exception.UserNotFoundException;
import com.ccpa.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;
	
	private static final String status = "status";
	private static final String message = "message";
	
	@PostMapping("/User/login")
	public ResponseEntity<Map<String, Object>> UserLogin(@RequestBody Map<String, Object> body) throws UserNotFoundException {
		Map<String, Object> us = new HashMap<>();
		us.put(status, true);
		us.put(message, "User Logged in successfully!");
		us.put("data", userService.getUser(body.get("userId").toString(), body.get("password").toString()));
		return new ResponseEntity<>(us, HttpStatus.OK);
	}
}
