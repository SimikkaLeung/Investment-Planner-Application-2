package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@SpringBootTest

class EmployeeRepositoryImplTest {

	@Autowired
	private EmployeeRepository testEmployeeRepo;
	
	@Test
	void testFindById() {
		assertEquals(testEmployeeRepo.findById(1).getEmployee_id(),1);
	}
	
	@Test
	void testFindFullNameById() {				
		assertEquals(testEmployeeRepo.findFullNameById(1).trim(),"Kelvin Cheung");
	}
	

}
