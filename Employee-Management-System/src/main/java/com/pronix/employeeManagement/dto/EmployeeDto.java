package com.pronix.employeeManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private Long id;
	private String name;
	private String email;
	private Double salary;
	
}
