package com.pronix.employeeManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pronix.employeeManagement.entity.User;
import com.pronix.employeeManagement.exception.AllDataRequiredException;
import com.pronix.employeeManagement.repository.UserRepository;
import com.pronix.employeeManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	// creation of
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	@Override
	public String saveUser(User user) {
		if (user.getUsername() != null && user.getPassword() != null) {
			user.setPassword(encoder.encode(user.getPassword()));
			User savedUser = userRepository.save(user);
			return "User saved with username : " + savedUser.getUsername();
		} else {
			throw new AllDataRequiredException("All required fields must be provide.");
		}
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();

	}

}
