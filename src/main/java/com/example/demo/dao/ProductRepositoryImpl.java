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
	public Product findById(Integer productId) {
		return jdbcTemplate.queryForObject("SELECT * FROM product WHERE product_id = ?", BeanPropertyRowMapper.newInstance(Product.class), productId);
	}

	@Override
	public List<Product> findAll() {
		return jdbcTemplate.query("SELECT * FROM product", BeanPropertyRowMapper.newInstance(Product.class));
	}

	@Override
	public List<Product> findByCriteria(BigDecimal principal, BigDecimal targetRate, Integer numOfDays) {
		return jdbcTemplate.query("SELECT * FROM product WHERE ? >= effective_rate AND ? >= min_principal AND ? <= max_principal AND ? >= num_of_days ORDER BY effective_rate DESC, num_of_days ASC"
				, BeanPropertyRowMapper.newInstance(Product.class), targetRate, principal, principal, numOfDays);
	}

	@Override
	public List<Product> findByCriteria(Questionnaire quest) {
		return jdbcTemplate.query("SELECT * FROM product WHERE ? >= effective_rate AND ? >= min_principal AND ? <= max_principal AND ? >= num_of_days ORDER BY effective_rate DESC, num_of_days ASC"
				, BeanPropertyRowMapper.newInstance(Product.class),quest.getTargetRate(), quest.getPrincipal(), quest.getPrincipal(), quest.getNumOfDays());
	}
	
}
