package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Suggestion;

@Repository
public class SuggestionRepositoryImpl implements SuggestionRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Suggestion suggestion) {
		return jdbcTemplate.update("INSERT INTO suggestion VALUES(?,?,?)",suggestion.getSuggestionId(),suggestion.getQuestId(),suggestion.getProductId());
		
	}

	@Override
	public Suggestion findById(Integer suggestionId) {
		return jdbcTemplate.queryForObject("SELECT * FROM suggestion WHERE suggestion_id = ?", 
				BeanPropertyRowMapper.newInstance(Suggestion.class), suggestionId);
	}

	@Override
	public List<Suggestion> findAll() {
		return jdbcTemplate.query("SELECT * FROM suggestion", 
				BeanPropertyRowMapper.newInstance(Suggestion.class));
	}

	@Override
	public List<Suggestion> findByQuestId(Integer questId) {
		return jdbcTemplate.query("SELECT * FROM suggestion WHERE quest_id = ?", 
				BeanPropertyRowMapper.newInstance(Suggestion.class), questId);
	}

	@Override
	public List<Suggestion> findByProductId(Integer productId) {
		return jdbcTemplate.query("SELECT * FROM suggestion WHERE product_id = ?", 
				BeanPropertyRowMapper.newInstance(Suggestion.class), productId);
	}

	@Override
	public Integer findMaxSuggestionId() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM suggestion", Integer.class);
	}

	@Override
	public int delete(Suggestion suggestion) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM suggestion WHERE suggestion_id = ?",suggestion.getSuggestionId());
	}
	
	
	
	
}
