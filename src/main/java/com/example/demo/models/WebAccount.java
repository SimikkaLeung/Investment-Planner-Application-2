package com.example.demo.models;

public class WebAccount {
	private String account_id;
	private String acc_password;
	private String user_type;
	
	public WebAccount() {
		super();

	}
	
	public WebAccount(String account_id, String acc_password, String user_type) {
		super();
		this.account_id = account_id;
		this.acc_password = acc_password;
		this.user_type = user_type;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getAcc_password() {
		return acc_password;
	}

	public void setAcc_password(String acc_password) {
		this.acc_password = acc_password;
	}

	public String getUser_type() {
		
//		System.out.println("WebAcc: " + user_type.equals("client") );
//		System.out.println("WebAcc: length" + user_type.length() );
//		System.out.println("WebAcc: " + user_type.trim().length() );
		return user_type.trim();
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type.toString();
	}

	@Override
	public String toString() {
		return "WebAccount [account_id=" + account_id + ", acc_password=" + acc_password + ", user_type=" + user_type
				+ "]";
	}


	
	
}
