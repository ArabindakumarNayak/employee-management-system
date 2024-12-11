package com.pronix.employeeManagement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pronix.employeeManagement.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(){
		return null;
		
	}
	
}
