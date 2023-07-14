package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BankClientRepository;
import com.example.demo.dao.WebAccountRepository;
import com.example.demo.models.BankClient;
import com.example.demo.models.WebAccount;

@Service
public class InvestmentPlannerSecurityServiceImpl implements InvestmentPlannerSecurityService {
		
		// This service class only work with the security controller to obtain the current user details.
	
		@Autowired	
		private WebAccountRepository accountRepo;
		
		@Autowired
		private BankClientRepository clientRepo;

		@Override
		public List<WebAccount> findAllAccounts() {
			return accountRepo.findAll();
		}
		
		// Get the clientId of the current user by the accountId they use to log in.
		public BankClient findClientbyAccountId() {
			Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (currentUser instanceof UserDetails) {
			  String accountId = ((UserDetails) currentUser).getUsername();
			  return clientRepo.findByAccountId(accountId);
			} else {
				System.out.println("No");
			  String accountId = currentUser.toString();
			  return clientRepo.findByAccountId(accountId);
			}
		}
		
		// Get the userType of the current user by the accountId they use to log in.
		@Override
		public String findUserTypebyAccountId() {
			Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (currentUser instanceof UserDetails) {
				String accountId = ((UserDetails) currentUser).getUsername();
			 	return accountRepo.findUserTypeById(accountId).trim();
			} else {
				System.out.println("No");
				String accountId = currentUser.toString();
				return accountRepo.findUserTypeById(accountId).trim();
			}

		}

}
