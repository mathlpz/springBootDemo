package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserByName() {
	    User user = userRepository.findByUserName("aa");
	    System.out.println("若下面没出现“无缓存的时候调用”字样，且能打印出数据表示测试成功");
	    
	    return user;
	}
}
