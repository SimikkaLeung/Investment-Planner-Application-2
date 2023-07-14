package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Questionnaire;
@SpringBootTest
class ProductRepositoryImplTest {

	@Autowired
	private ProductRepository productRepo;
	
	@Test
	void testFindById() {
		assertEquals(productRepo.findById(1).getProductId(),1);
	}
	
	@Test
	void testFindAll() {
		assertEquals(productRepo.findAll().size(),10);
	}	
	
	@Test
	void testFindByCriteria() {
		Questionnaire quest = new Questionnaire(222,2,new BigDecimal(3000),new BigDecimal(3),183);
		assertEquals(productRepo.findByCriteria(quest).size(),2);
		
		assertEquals(productRepo.findByCriteria(new BigDecimal(3000),new BigDecimal(3),183).size(),2);
	}	
	

}
