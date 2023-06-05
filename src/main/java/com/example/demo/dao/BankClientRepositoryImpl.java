package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.BankClient;

@Repository
public class BankClientRepositoryImpl implements BankClientRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BankClient findById(Integer client_id) {	
		return jdbcTemplate.queryForObject("SELECT * FROM bankclient WHERE client_id = ?", BeanPropertyRowMapper.newInstance(BankClient.class), client_id);
	}

	@Override
	public BankClient findByAccountId(String account_id) {
		return jdbcTemplate.queryForObject("SELECT * FROM bankclient WHERE account_id = ?", 
				BeanPropertyRowMapper.newInstance(BankClient.class), account_id);
	}

	@Override
	public List<BankClient> findAll() {
		return jdbcTemplate.query("SELECT * FROM bankclient", BeanPropertyRowMapper.newInstance(BankClient.class));
	}


	
	
	
}
