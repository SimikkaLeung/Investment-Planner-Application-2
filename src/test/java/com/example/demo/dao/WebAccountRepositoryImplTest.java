package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class WebAccountRepositoryImplTest {

	@Autowired
	private WebAccountRepository accountRepo;
	
	@Test
	void testFindAll() {
		assertEquals(accountRepo.findAll().size(),9);
	}
	
	@Test
	void testFindUserTypeById() {
		assertEquals(accountRepo.findUserTypeById("simleung").trim(),"client");
	}

}
