package com.pronix.employeeManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronix.employeeManagement.entity.User;
import com.pronix.employeeManagement.exception.AllDataRequiredException;
import com.pronix.employeeManagement.repository.UserRepository;
import com.pronix.employeeManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String saveUser(User user) {
		if (user.getUsername() != null && user.getPassword() != null) {
			User savedUser = userRepository.save(user);
			return "User saved with username : " + user.getUsername();
		} else {
			throw new AllDataRequiredException("All required fields must be provide.");
		}
	}

}
