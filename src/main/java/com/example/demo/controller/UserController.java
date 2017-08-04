package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/getUserByName")
	@Cacheable(value="user-key")
	public User getUserByName() {
	    User user = userService.getUserByName();
	    
	    return user;
	}
	
}
