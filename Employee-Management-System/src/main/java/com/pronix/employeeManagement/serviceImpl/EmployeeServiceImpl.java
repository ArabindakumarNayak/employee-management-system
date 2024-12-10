package com.pronix.employeeManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pronix.employeeManagement.entity.Employee;
import com.pronix.employeeManagement.repository.EmployeeRepository;
import com.pronix.employeeManagement.service.EmployeeService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//		public EmployeeService(EmployeeRepository employeeRepository) {
//			this.employeeRepository = employeeRepository;
//		}
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found!"));
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public String deleteEmployee(Long id) throws Exception {
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new Exception("User Id not found..."));
		employeeRepository.delete(emp);
		return "Employee " + id + " is deleted Sucessfully";
	}

	
	
	@Override
	public Employee updateEmployee(Long employeeId, Employee emp) throws Exception {
	    // Fetch the existing employee by ID
	    Employee existingEmployee = employeeRepository.findById(employeeId)
	            .orElseThrow(() -> new Exception("Employee not found for ID: " + employeeId));

	    // Update name if provided and different from the current value
	    if (emp.getName() != null && !emp.getName().isEmpty()) {
	        existingEmployee.setName(emp.getName());
	    }

	    // Update email if provided and different from the current value
	    if (emp.getEmail() != null && !emp.getEmail().isEmpty()) {
	        existingEmployee.setEmail(emp.getEmail());
	    }

	    // Update salary if valid and greater than 0
	    if (emp.getSalary() != null && emp.getSalary() > 0) {
	        existingEmployee.setSalary(emp.getSalary());
	    }

	    // Update department name if provided and different from the current value
	    if (emp.getDepartmentName() != null && !emp.getDepartmentName().isEmpty()) {
	        existingEmployee.setDepartmentName(emp.getDepartmentName());
	    }

	    // Save and return the updated employee
	    return employeeRepository.save(existingEmployee);
	}




//	public Employee dtoToEmployee(EmployeeDto employeeDto) {
//		Employee employee = new Employee();
//		employee.setId(employeeDto.getId());
//		employee.setName(employeeDto.getName());
//		employee.setEmail(employeeDto.getEmail());
//		employee.setSalary(employeeDto.getSalary());
//		return employee;
//	}
//
//	public EmployeeDto employeeToDto(Employee emp) {
//		EmployeeDto dto = new EmployeeDto();
//		dto.setId(emp.getId());
//		dto.setName(emp.getName());
//		dto.setEmail(emp.getEmail());
//		dto.setSalary(emp.getSalary());
//		return dto;
//	}

}
