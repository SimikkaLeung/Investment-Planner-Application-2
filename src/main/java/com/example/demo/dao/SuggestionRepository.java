package com.example.demo.dao;

import java.util.List;

import com.example.demo.models.Suggestion;

public interface SuggestionRepository {
	
	public int save(Suggestion suggestion);	
	
	public Suggestion findById(Integer suggestionId);	
	
	public List<Suggestion> findAll();	
	
	public List<Suggestion> findByQuestId(Integer questId);	
	
	public List<Suggestion> findByProductId(Integer productId);		
	
	public Integer findMaxSuggestionId();
	
	public int delete(Suggestion suggestion);	
	
}
