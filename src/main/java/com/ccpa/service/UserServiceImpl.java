package com.ccpa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccpa.exception.UserNotFoundException;
import com.ccpa.model.User;
import com.ccpa.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUser(String userId, String password) throws UserNotFoundException {
		User us = userRepository.getUserByUserIdAndPassword(userId, password);
		if(us != null)
			return us;
		throw new UserNotFoundException("UserId And Password is Incorrect!...");
	}

}
