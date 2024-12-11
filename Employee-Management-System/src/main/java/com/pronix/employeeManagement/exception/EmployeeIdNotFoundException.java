package com.pronix.employeeManagement.exception;

public class EmployeeIdNotFoundException extends RuntimeException{

	public EmployeeIdNotFoundException(String message) {
		super(message);
	}
}
