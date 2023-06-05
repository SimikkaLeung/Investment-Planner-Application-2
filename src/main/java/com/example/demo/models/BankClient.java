package com.example.demo.models;

public class BankClient {
	private Integer client_id;
	private String account_id;
	private String client_fname;
	private String client_lname;
	private Integer employee_assigned;
	
	public BankClient() {
		super();
	}
	
	public BankClient(Integer client_id, String account_id, String client_fname, String client_lname,
			Integer employee_assigned) {
		super();
		this.client_id = client_id;
		this.account_id = account_id;
		this.client_fname = client_fname;
		this.client_lname = client_lname;
		this.employee_assigned = employee_assigned;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getClient_fname() {
		return client_fname;
	}

	public void setClient_fname(String client_fname) {
		this.client_fname = client_fname;
	}

	public String getClient_lname() {
		return client_lname;
	}

	public void setClient_lname(String client_lname) {
		this.client_lname = client_lname;
	}

	public Integer getEmployee_assigned() {
		return employee_assigned;
	}

	public void setEmployee_assigned(Integer employee_assigned) {
		this.employee_assigned = employee_assigned;
	}

	@Override
	public String toString() {
		return "BankClient [client_id=" + client_id + ", account_id=" + account_id + ", client_fname=" + client_fname
				+ ", client_lname=" + client_lname + ", employee_assigned=" + employee_assigned + "]";
	}
	
	

}
