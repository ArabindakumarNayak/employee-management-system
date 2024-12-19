package com.pronix.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pronix.employeeManagement.entity.User;
import com.pronix.employeeManagement.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/saveUser/")
	public String saveUser(@RequestBody User user) {
		return userServiceImpl.saveUser(user);
	}

	@GetMapping("/getAllUsers/")
	public List<User> getAll() {
		return userServiceImpl.getAllUsers();
	}
	
	@PostMapping("/login/")
	public String login(@RequestBody User user) {
		return userServiceImpl.login(user);
	}

}
