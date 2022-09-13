package com.ccpa.service;

import com.ccpa.exception.UserNotFoundException;
import com.ccpa.model.User;

public interface UserService {
	//service for login of user
	public User getUser(String userId, String password) throws UserNotFoundException;
}
