package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class BankClientRepositoryImplTest {

	@Autowired
	private BankClientRepository testClientRepo;
	
	@Test
	void testById() {
		assertEquals(testClientRepo.findById(1).getClient_id(),1);
	}
	

	@Test
	void testFindByAccountId() {
		assertEquals(testClientRepo.findByAccountId("simleung").getClient_lname(),"TestLeung");
	}
	
	@Test
	void testFindAll() {
		assertEquals(testClientRepo.findAll().size(),6);
	}
	

	
}
