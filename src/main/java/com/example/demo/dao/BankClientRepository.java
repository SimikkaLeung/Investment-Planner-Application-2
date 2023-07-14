package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.BankClient;

public interface BankClientRepository {
	
	public BankClient findById(Integer clientId);
	
	public BankClient findByAccountId(String accountId);
	
	public List<BankClient> findAll();
		
}

