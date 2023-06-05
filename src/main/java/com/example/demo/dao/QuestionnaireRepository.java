package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.Questionnaire;

public interface QuestionnaireRepository {

	public int save(Questionnaire quest);
	
	public Questionnaire findById(Integer quest_id);
	
	public List<Questionnaire> findAll();
	
	public List<Questionnaire> findByClientId(Integer client_id);
	
	public Integer findMaxQuestId();
	
	public int delete(Questionnaire quest);
	
}
