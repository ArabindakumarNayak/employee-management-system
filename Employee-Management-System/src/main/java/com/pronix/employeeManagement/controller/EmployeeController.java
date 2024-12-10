package com.pronix.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pronix.employeeManagement.entity.Employee;
import com.pronix.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController extends EmployeeService {
	@Autowired
	private EmployeeService employeeService;

//	public EmployeeController (EmployeeService employeeService) {
//		this.employeeService=employeeService;
//	}
	@Override
	@GetMapping("/")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	@Override
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@Override
	@PostMapping("/")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}
	
	@Override
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) throws Exception {
		return employeeService.deleteEmployee(id);
	}
	
	@Override
	@PutMapping("/")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
		
	}
	

}
