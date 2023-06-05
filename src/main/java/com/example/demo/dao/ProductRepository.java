package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.models.Product;
import com.example.demo.models.Questionnaire;

public interface ProductRepository {
	
	public Product findById(Integer product_id);
	
	public List<Product> findAll();
	
	public List<Product> findByCriteria(BigDecimal target_rate, BigDecimal principal, Integer num_of_days );
	
	public List<Product> findByCriteria(Questionnaire quest);
}
