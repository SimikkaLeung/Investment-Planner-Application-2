package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class WebAccountRepositoryImplTest {

	@Autowired
	private WebAccountRepository testAccountRepo;
	
	@Test
	void testFindAll() {
		assertEquals(testAccountRepo.findAll().size(),9);
	}
	
	@Test
	void testFindUserTypeById() {
		assertEquals(testAccountRepo.findUserTypeById("simleung").trim(),"client");
	}

}
