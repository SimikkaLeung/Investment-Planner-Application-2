package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dao.BankClientRepository;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.QuestionnaireRepository;
import com.example.demo.dao.SuggestionRepository;
import com.example.demo.dao.TestBankClientRepositoryImpl;
import com.example.demo.dao.TestEmployeeRepositoryImpl;
import com.example.demo.dao.TestProductRepositoryImpl;
import com.example.demo.dao.TestQuestionnaireRepositoryImpl;
import com.example.demo.dao.TestSuggestionRepositoryImpl;
import com.example.demo.dao.TestWebAccountRepositoryImpl;
import com.example.demo.dao.WebAccountRepository;
@ComponentScan
@Configuration
public class TestConfiguration {
	@Bean
	public BankClientRepository testClientRepo (){
		return new TestBankClientRepositoryImpl();
	}
	
	@Bean
	public ProductRepository testProductRepo (){
		return new TestProductRepositoryImpl();
	}
	
	@Bean
	public QuestionnaireRepository testQuestRepo (){
		return new TestQuestionnaireRepositoryImpl();
	}
	
	@Bean
	public SuggestionRepository testSuggRepo (){
		return new TestSuggestionRepositoryImpl();
	}
		
	@Bean
	public WebAccountRepository testAccountRepo (){
		return new TestWebAccountRepositoryImpl();
	}
	
	@Bean
	public EmployeeRepository testEmployeeRepo (){
		return new TestEmployeeRepositoryImpl();
	}
}
