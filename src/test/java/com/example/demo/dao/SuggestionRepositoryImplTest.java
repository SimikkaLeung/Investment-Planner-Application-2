package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Suggestion;
@SpringBootTest
class SuggestionRepositoryImplTest {
	
	@Autowired
	private SuggestionRepository suggRepo;
	
	@Test
	void testSaveAndDelete() {
		
		Suggestion sugg = new Suggestion(30,2,2);
		assertEquals(suggRepo.save(sugg),1);
		assertEquals(suggRepo.delete(sugg),1);
		
	}
	
	@Test
	void testFindById() {
		assertEquals(suggRepo.findById(2).getSuggestionId(),2);		
	}
	
	@Test
	void testFindAll() {
		assertEquals(suggRepo.findAll().size(),17);		
	}
	
	@Test
	void testFindByQuestId() {
		assertEquals(suggRepo.findByQuestId(5).size(),3);		
	}

	@Test
	void testFindByProductId() {
		assertEquals(suggRepo.findByProductId(1).size(),3);		
	}
	
	@Test
	void testFindMaxSuggestionId() {
		assertEquals(suggRepo.findMaxSuggestionId(),17);		
	}
	
}
