package com.pronix.employeeManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronix.employeeManagement.entity.Employee;
import com.pronix.employeeManagement.exception.AllDataRequiredException;
import com.pronix.employeeManagement.exception.EmployeeNotFoundException;
import com.pronix.employeeManagement.repository.EmployeeRepository;
import com.pronix.employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found!"));
	}

	@Override
	public String saveEmployee(Employee emp) {
		if (emp.getName() != null && emp.getEmail() != null && emp.getDepartmentName() != null && emp.getSalary() > 0) {

			// Save employee to the repository
			Employee savedEmployee = employeeRepository.save(emp);
			return "Employee saved with emp Id : " + savedEmployee.getId();
		} else {
			throw new AllDataRequiredException("All required fields must be provided.");
		}
	}

	@Override
	public String deleteEmployee(Long id) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return "Employee with ID " + id + " has been deleted successfully.";
		} else {
			throw new EmployeeNotFoundException("Employee with ID " + id + " is not found.");
		}
	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee emp) throws EmployeeNotFoundException {
	    // Fetch the existing employee by ID
	    Employee existingEmployee = employeeRepository.findById(employeeId)
	            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found for ID: " + employeeId));

	    // Update properties only if they are valid and different from the current values
	    if (emp.getName() != null && !emp.getName().isEmpty() && !emp.getName().equals(existingEmployee.getName())) {
	        existingEmployee.setName(emp.getName());
	    }

	    if (emp.getEmail() != null && !emp.getEmail().isEmpty() && !emp.getEmail().equals(existingEmployee.getEmail())) {
	        existingEmployee.setEmail(emp.getEmail());
	    }

	    if (emp.getSalary() != null && emp.getSalary() > 0 && !emp.getSalary().equals(existingEmployee.getSalary())) {
	        existingEmployee.setSalary(emp.getSalary());
	    }

	    if (emp.getDepartmentName() != null && !emp.getDepartmentName().isEmpty()
	            && !emp.getDepartmentName().equals(existingEmployee.getDepartmentName())) {
	        existingEmployee.setDepartmentName(emp.getDepartmentName());
	    }

	    // Save and return the updated employee
	    return employeeRepository.save(existingEmployee);
	}

//	@Override
//	public List<Employee> addEmployees(List<Employee> employees) {
//	    // Validate the input list
//	    if (employees == null || employees.isEmpty()) {
//	        throw new AllDataRequiredException("Employee list cannot be null or empty.");
//	    }
//
//	    // Ensure all required fields are provided for each employee
//	    for (Employee emp : employees) {
//	        if (emp.getName() == null || emp.getEmail() == null || emp.getDepartmentName() == null || emp.getSalary() == null || emp.getSalary() <= 0) {
//	            throw new AllDataRequiredException("All required fields must be provided for each employee.");
//	        }
//	    }
//
//	    // Save all employees to the repository
//	    return employeeRepository.saveAll(employees);
//	}
	
//	@Override
//	public List<Employee> addEmployees(List<Employee> employees) {
//		em
//		return employees;
//		
//	}
//	
	



}