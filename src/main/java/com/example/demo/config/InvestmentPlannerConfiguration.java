package com.example.demo.config;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.dao.BankClientRepository;
import com.example.demo.dao.BankClientRepositoryImpl;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.dao.EmployeeRepositoryImpl;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.ProductRepositoryImpl;
import com.example.demo.dao.QuestionnaireRepository;
import com.example.demo.dao.QuestionnaireRepositoryImpl;
import com.example.demo.dao.SuggestionRepository;
import com.example.demo.dao.SuggestionRepositoryImpl;
import com.example.demo.dao.WebAccountRepository;
import com.example.demo.dao.WebAccountRepositoryImpl;

@Configuration
public class InvestmentPlannerConfiguration {

	@Bean
	public BankClientRepository clientRepo (){
		return new BankClientRepositoryImpl();
	}
	
	@Bean
	public ProductRepository productRepo (){
		return new ProductRepositoryImpl();
	}
	
	@Bean
	public QuestionnaireRepository questRepo (){
		return new QuestionnaireRepositoryImpl();
	}
	
	@Bean
	public SuggestionRepository suggRepo (){
		return new SuggestionRepositoryImpl();
	}
		
	@Bean
	public WebAccountRepository accountRepo (){
		return new WebAccountRepositoryImpl();
	}
	
	@Bean
	public EmployeeRepository employeeRepo (){
		return new EmployeeRepositoryImpl();
	}
	
}
