package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class BankClientRepositoryImplTest {

	@Autowired
	private BankClientRepository clientRepo;
	
	@Test
	void testById() {
		assertEquals(clientRepo.findById(1).getClientId(),1);
	}
	

	@Test
	void testFindByAccountId() {
		assertEquals(clientRepo.findByAccountId("simleung").getClientLname(),"TestLeung");
	}
	
	@Test
	void testFindAll() {
		assertEquals(clientRepo.findAll().size(),6);
	}
	

	
}
