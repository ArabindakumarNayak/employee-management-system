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

	@Autowired
	private JWTServiceImpl jwtService;

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

	@Override
	public String login(User user) {
		// Check if the user exists in the repository by username
		User existingUser = userRepository.findByUsername(user.getUsername());

		if (existingUser != null) {
			// Validate the password using BCryptPasswordEncoder's matches method
			if (encoder.matches(user.getPassword(), existingUser.getPassword())) {
				// Return a success message or generate a token

				String token = jwtService.generateToken(user.getUsername());

				return token;
			} else {
				// Return a failure message for incorrect password
				return "Invalid password!";
			}
		} else {
			// Return a failure message for user not found
			return "User not found!";
		}
	}

}
