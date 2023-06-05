package com.example.demo.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Questionnaire;
@SpringBootTest
class QuestionnaireRepositoryImplTest {

	@Autowired
	private QuestionnaireRepository testQuestRepo;
	
	@Test
	void testSaveAndDelete() {
		
		Questionnaire quest = new Questionnaire(2222,2,new BigDecimal(5000),new BigDecimal(5),500);
		assertEquals(testQuestRepo.save(quest),1);
		assertEquals(testQuestRepo.delete(quest),1);
	}

	
	@Test
	void testFindById() {
		assertEquals(testQuestRepo.findById(3).getQuest_id(),3);
	}

	@Test
	void testFindAll() {
		assertTrue(testQuestRepo.findAll().size()==5);
	}
	
	@Test
	void testFindClientId() {
		assertTrue(testQuestRepo.findByClientId(1).size()==3);
	}
	
	@Test
	void testFindMaxQuestId() {
		assertTrue(testQuestRepo.findMaxQuestId()==5);
	}
	
	
	
}
