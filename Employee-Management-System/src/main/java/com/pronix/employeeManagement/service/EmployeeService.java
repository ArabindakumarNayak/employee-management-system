package com.pronix.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronix.employeeManagement.entity.Employee;
import com.pronix.employeeManagement.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

//	public EmployeeService(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found!"));
	}

	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	public String deleteEmployee(Long id) throws Exception {
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new Exception("User Id not found..."));
		employeeRepository.delete(emp);
		return "Employee " + id + " is deleted Sucessfully";
	}
	
	public Employee updateEmployee(Employee emp) throws Exception {
		Employee employee = employeeRepository.findById(emp.getId()).orElseThrow(()->new Exception("Employee is not found..."));
		employeeRepository.save(employee);
		return employeeRepository.save(emp);
	}

}
