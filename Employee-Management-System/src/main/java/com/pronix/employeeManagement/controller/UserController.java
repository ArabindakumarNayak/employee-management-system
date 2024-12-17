package com.pronix.employeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pronix.employeeManagement.entity.User;
import com.pronix.employeeManagement.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/registerUser")
public class UserController{

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/saveUser/")
	public String saveUser(@RequestBody User user) {
		return userServiceImpl.saveUser(user);
	}
	
}
