package com.example.demo.dao;

import com.example.demo.models.Employee;

public interface EmployeeRepository {

	public Employee findById(Integer employeeId);
	
	public String findFullNameById(Integer employeeId);
	
}
