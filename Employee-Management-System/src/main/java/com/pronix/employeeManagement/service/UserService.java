package com.pronix.employeeManagement.service;

import java.util.List;

import com.pronix.employeeManagement.entity.User;

public interface UserService {
	public String saveUser(User user);
	
	public List<User> getAllUsers();
	
	public String login(User user);
}
