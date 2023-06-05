package com.example.demo.dao;

import com.example.demo.models.Employee;

public interface EmployeeRepository {

	public Employee findById(Integer employee_id);
	
	public String findFullNameById(Integer employee_id);
	
}
