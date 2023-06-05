package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Suggestion;
@SpringBootTest
class SuggestionRepositoryImplTest {
	
	@Autowired
	private SuggestionRepository testSuggRepo;
	
	@Test
	void testSaveAndDelete() {
		
		Suggestion sugg = new Suggestion(30,2,2);
		assertEquals(testSuggRepo.save(sugg),1);
		assertEquals(testSuggRepo.delete(sugg),1);
		
	}
	
	@Test
	void testFindById() {
		assertEquals(testSuggRepo.findById(2).getSuggestion_id(),2);		
	}
	
	@Test
	void testFindAll() {
		assertEquals(testSuggRepo.findAll().size(),17);		
	}
	
	@Test
	void testFindByQuestId() {
		assertEquals(testSuggRepo.findByQuestId(5).size(),3);		
	}

	@Test
	void testFindByProductId() {
		assertEquals(testSuggRepo.findByProductId(1).size(),3);		
	}
	
	@Test
	void testFindMaxSuggestionId() {
		assertEquals(testSuggRepo.findMaxSuggestionId(),17);		
	}
	
}
