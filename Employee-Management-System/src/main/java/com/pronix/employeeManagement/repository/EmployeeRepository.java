package com.pronix.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pronix.employeeManagement.entity.Employee;
import com.pronix.employeeManagement.entity.User;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	User findByUserName(String username);

}
