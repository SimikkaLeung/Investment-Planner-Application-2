package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.BankClient;
import com.example.demo.models.WebAccount;



public interface InvestmentPlannerSecurityService {
	
	public List<WebAccount> findAllAccounts();
	public BankClient findClientbyAccountId();
	public String findUserTypebyAccountId();
}
