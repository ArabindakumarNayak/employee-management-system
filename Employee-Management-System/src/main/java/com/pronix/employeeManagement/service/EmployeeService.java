package com.pronix.employeeManagement.service;

import java.util.List;

import com.pronix.employeeManagement.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(Long id);

	public String saveEmployee(Employee emp);

	public String deleteEmployee(Long id) throws Exception;

	Employee updateEmployee(Long employeeId, Employee emp) throws Exception;

}