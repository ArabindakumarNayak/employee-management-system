package com.pronix.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pronix.employeeManagement.entity.Employee;
import com.pronix.employeeManagement.exception.EmployeeNotFoundException;
import com.pronix.employeeManagement.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/")
public class EmployeeController extends EmployeeServiceImpl {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

//	public EmployeeController (EmployeeService employeeService) {
//		this.employeeService=employeeService;
//	}

	@GetMapping("/getAllEmployee/")
	public List<Employee> getAllEmployee() {
		return employeeServiceImpl.getAllEmployee();
	}

	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeServiceImpl.getEmployeeById(id);
	}

	@PostMapping("/saveEmployee/")
	public String saveEmployee(@RequestBody Employee emp) {
		return employeeServiceImpl.saveEmployee(emp);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return employeeServiceImpl.deleteEmployee(id);
	}

	@PutMapping("/updateEmployeeById/{id}")
	public ResponseEntity<?> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
		try {
			// Call the service layer to update the employee by ID
			Employee updatedEmployee = employeeServiceImpl.updateEmployee(id, employee);
			// Return updated employee with status 200 OK
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		} 
		catch (EmployeeNotFoundException ex) {
	        // Return a 404 Not Found with a clear error message if the employee is not found
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
		
		catch (Exception e) {
			// If an error occurs (e.g., employee not found), return a 404 Not Found with
			// error message
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}