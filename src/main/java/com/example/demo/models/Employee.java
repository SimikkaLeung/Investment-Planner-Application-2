package com.example.demo.models;

public class Employee {
	private Integer employeeId;
	private String accountId;
	private String employeeFname;
	private String employeeLname;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer employeeId, String accountId, String employeeFname, String employeeLname) {
		super();
		this.employeeId = employeeId;
		this.accountId = accountId;
		this.employeeFname = employeeFname;
		this.employeeLname = employeeLname;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getEmployeeFname() {
		return employeeFname;
	}

	public void setEmployeeFname(String employeeFname) {
		this.employeeFname = employeeFname;
	}

	public String getEmployeeLname() {
		return employeeLname;
	}

	public void setEmployeeLname(String employeeLname) {
		this.employeeLname = employeeLname;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", accountId=" + accountId + ", employeeFname="
				+ employeeFname + ", employeeLname=" + employeeLname + "]";
	}
	
}
