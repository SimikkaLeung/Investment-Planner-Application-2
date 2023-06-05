package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.WebAccount;

@Repository
public class WebAccountRepositoryImpl implements WebAccountRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<WebAccount> findAll() {
		return jdbcTemplate.query("SELECT * FROM webaccount",BeanPropertyRowMapper.newInstance(WebAccount.class));
	}

	@Override
	public String findUserTypeById(String account_id) {
		return jdbcTemplate.queryForObject("SELECT user_type FROM webaccount WHERE account_id = ?", String.class, account_id);
	}
	
	
	
	
}
