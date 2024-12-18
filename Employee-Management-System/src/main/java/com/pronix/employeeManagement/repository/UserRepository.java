package com.pronix.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pronix.employeeManagement.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	User findByUsername(String username);
}
	