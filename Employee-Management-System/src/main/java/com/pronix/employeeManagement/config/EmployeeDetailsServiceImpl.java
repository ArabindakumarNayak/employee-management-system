package com.pronix.employeeManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pronix.employeeManagement.entity.Employee;
import com.pronix.employeeManagement.entity.User;
import com.pronix.employeeManagement.entity.UserPrincipal;
import com.pronix.employeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeDetailsServiceImpl  implements UserDetailsService{
	
	@Autowired
	private  EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		User user=employeeRepository.findByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User not found...");
		}
		
		return new UserPrincipal(user);
		
	}

}
