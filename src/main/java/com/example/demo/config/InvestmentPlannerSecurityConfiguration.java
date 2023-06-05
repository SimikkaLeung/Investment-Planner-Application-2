package com.example.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.models.WebAccount;
import com.example.demo.services.InvestmentPlannerSecurityService;
@Configuration
@EnableWebSecurity
public class InvestmentPlannerSecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	//Website visitors can browse the home page and the product page 
	//without login. Employees cannot browse clients's pages and 
	//clients cannot not browse employees' pages.
	
	
	@Autowired
	private InvestmentPlannerSecurityService securityService;
		
	
	// Load the account info for the login form.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		List<WebAccount> accountList = securityService.findAllAccounts();
		for(WebAccount account: accountList) {
			auth.inMemoryAuthentication().withUser(account.getAccount_id())
				.password(this.passwordEncoder().encode(account.getAcc_password())).roles(account.getUser_type());
			
		}
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/client/*").hasRole("client")
		.antMatchers("/employee/*").hasRole("employee")
		.antMatchers("/*").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
