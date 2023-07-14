package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.Questionnaire;

public interface QuestionnaireRepository {

	public int save(Questionnaire quest);
	
	public Questionnaire findById(Integer questId);
	
	public List<Questionnaire> findAll();
	
	public List<Questionnaire> findByClientId(Integer clientId);
	
	public Integer findMaxQuestId();
	
	public int delete(Questionnaire quest);
	
}
