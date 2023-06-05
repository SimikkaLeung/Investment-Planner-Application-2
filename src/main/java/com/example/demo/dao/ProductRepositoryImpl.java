package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Product;
import com.example.demo.models.Questionnaire;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Product findById(Integer product_id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * FROM product WHERE product_id = ?", BeanPropertyRowMapper.newInstance(Product.class), product_id);
	}

	@Override
	public List<Product> findAll() {
		return jdbcTemplate.query("SELECT * FROM product", BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public List<Product> findByCriteria(BigDecimal principal, BigDecimal target_rate, Integer num_of_days) {
		return jdbcTemplate.query("SELECT * FROM product WHERE ? >= effective_rate AND ? >= min_principal AND ? <= max_principal AND ? >= num_of_days ORDER BY effective_rate DESC, num_of_days ASC"
				, BeanPropertyRowMapper.newInstance(Product.class), target_rate, principal, principal, num_of_days);
	}

	@Override
	public List<Product> findByCriteria(Questionnaire quest) {
		return jdbcTemplate.query("SELECT * FROM product WHERE ? >= effective_rate AND ? >= min_principal AND ? <= max_principal AND ? >= num_of_days ORDER BY effective_rate DESC, num_of_days ASC"
				, BeanPropertyRowMapper.newInstance(Product.class),quest.getTarget_rate(), quest.getPrincipal(), quest.getPrincipal(), quest.getNum_of_days());
	}
	
}
