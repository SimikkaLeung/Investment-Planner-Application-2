package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee findById(Integer employeeId) {
		return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE employee_id = ?", BeanPropertyRowMapper.newInstance(Employee.class),employeeId);
	}

	@Override
	public String findFullNameById(Integer employeeId) {
		return jdbcTemplate.queryForObject("SELECT CONCAT(employee_fname, ' ', employee_lname) FROM employee WHERE employee_id = ?", String.class, employeeId);
	}
	
	
	
	
}
