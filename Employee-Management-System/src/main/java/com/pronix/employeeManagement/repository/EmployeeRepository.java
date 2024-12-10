package com.pronix.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pronix.employeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
