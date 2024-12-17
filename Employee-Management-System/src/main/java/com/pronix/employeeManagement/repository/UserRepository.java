package com.pronix.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pronix.employeeManagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
	