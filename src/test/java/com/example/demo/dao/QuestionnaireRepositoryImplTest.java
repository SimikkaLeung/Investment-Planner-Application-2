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
	private QuestionnaireRepository questRepo;
	
	@Test
	void testSaveAndDelete() {
		
		Questionnaire quest = new Questionnaire(2222,2,new BigDecimal(5000),new BigDecimal(5),500);
		assertEquals(questRepo.save(quest),1);
		assertEquals(questRepo.delete(quest),1);
	}

	
	@Test
	void testFindById() {
		assertEquals(questRepo.findById(3).getQuestId(),3);
	}

	@Test
	void testFindAll() {
		assertTrue(questRepo.findAll().size()==5);
	}
	
	@Test
	void testFindClientId() {
		assertTrue(questRepo.findByClientId(1).size()==3);
	}
	
	@Test
	void testFindMaxQuestId() {
		assertTrue(questRepo.findMaxQuestId()==5);
	}
	
	
	
}
