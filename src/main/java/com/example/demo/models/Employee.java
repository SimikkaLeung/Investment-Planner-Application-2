package com.example.demo.models;

public class Employee {
	private Integer employee_id;
	private String account_id;
	private String employee_fname;
	private String employee_lname;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer employee_id, String account_id, String employee_fname, String employee_lname) {
		super();
		this.employee_id = employee_id;
		this.account_id = account_id;
		this.employee_fname = employee_fname;
		this.employee_lname = employee_lname;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getEmployee_fname() {
		return employee_fname;
	}

	public void setEmployee_fname(String employee_fname) {
		this.employee_fname = employee_fname;
	}

	public String getEmployee_lname() {
		return employee_lname;
	}

	public void setEmployee_lname(String employee_lname) {
		this.employee_lname = employee_lname;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", account_id=" + account_id + ", employee_fname="
				+ employee_fname + ", employee_lname=" + employee_lname + "]";
	}
	
	
	
}
