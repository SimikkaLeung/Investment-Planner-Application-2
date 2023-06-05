package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.BankClient;

public interface BankClientRepository {
	
	public BankClient findById(Integer client_id);
	
	public BankClient findByAccountId(String account_id);
	
	public List<BankClient> findAll();
		
}

