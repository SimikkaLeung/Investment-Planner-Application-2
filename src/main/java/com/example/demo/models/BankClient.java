package com.example.demo.models;

public class BankClient {
	private Integer clientId;
	private String accountId;
	private String clientFname;
	private String clientLname;
	private Integer employeeAssigned;
	
	public BankClient() {
		super();
	}
	
	public BankClient(Integer clientId, String accountId, String clientFname, String clientLname,
			Integer employeeAssigned) {
		super();
		this.clientId = clientId;
		this.accountId = accountId;
		this.clientFname = clientFname;
		this.clientLname = clientLname;
		this.employeeAssigned = employeeAssigned;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getClientFname() {
		return clientFname;
	}

	public void setClientFname(String clientFname) {
		this.clientFname = clientFname;
	}

	public String getClientLname() {
		return clientLname;
	}

	public void setClientLname(String clientLname) {
		this.clientLname = clientLname;
	}

	public Integer getEmployeeAssigned() {
		return employeeAssigned;
	}

	public void setEmployeeAssigned(Integer employeeAssigned) {
		this.employeeAssigned = employeeAssigned;
	}

	@Override
	public String toString() {
		return "BankClient [clientId=" + clientId + ", accountId=" + accountId + ", clientFname=" + clientFname
				+ ", clientLname=" + clientLname + ", employeeAssigned=" + employeeAssigned + "]";
	}
	
	

}
