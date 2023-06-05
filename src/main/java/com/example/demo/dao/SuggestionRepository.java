package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.Suggestion;

public interface SuggestionRepository {
	
	public int save(Suggestion suggestion);	
	
	public Suggestion findById(Integer suggestion_id);	
	
	public List<Suggestion> findAll();	
	
	public List<Suggestion> findByQuestId(Integer quest_id);	
	
	public List<Suggestion> findByProductId(Integer product_id);		
	
	public Integer findMaxSuggestionId();
	
	public int delete(Suggestion suggestion);	
	
}
