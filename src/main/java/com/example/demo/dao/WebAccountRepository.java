package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.WebAccount;

public interface WebAccountRepository {

	//public int findById(String account_id);
	
	public List<WebAccount> findAll();
	public String findUserTypeById(String account_id);
	
}
