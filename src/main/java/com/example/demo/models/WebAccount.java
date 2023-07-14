package com.example.demo.models;

public class WebAccount {
	private String accountId;
	private String accPassword;
	private String userType;
	
	public WebAccount() {
		super();

	}
	
	public WebAccount(String accountId, String accPassword, String userType) {
		super();
		this.accountId = accountId;
		this.accPassword = accPassword;
		this.userType = userType;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccPassword() {
		return accPassword;
	}

	public void setAccPassword(String accPassword) {
		this.accPassword = accPassword;
	}

	public String getUserType() {
		
//		System.out.println("WebAcc: " + userType.equals("client") );
//		System.out.println("WebAcc: length" + userType.length() );
//		System.out.println("WebAcc: " + userType.trim().length() );
		return userType.trim();
	}

	public void setUserType(String userType) {
		this.userType = userType.toString();
	}

	@Override
	public String toString() {
		return "WebAccount [accountId=" + accountId + ", accPassword=" + accPassword + ", userType=" + userType
				+ "]";
	}


	
	
}
