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
		return jdbcTemplate.update("INSERT INTO suggestion VALUES(?,?,?)",suggestion.getSuggestion_id(),suggestion.getQuest_id(),suggestion.getProduct_id());
		
	}

	@Override
	public Suggestion findById(Integer suggestion_id) {
		return jdbcTemplate.queryForObject("SELECT * FROM suggestion WHERE suggestion_id = ?", 
				BeanPropertyRowMapper.newInstance(Suggestion.class), suggestion_id);
	}

	@Override
	public List<Suggestion> findAll() {
		return jdbcTemplate.query("SELECT * FROM suggestion", 
				BeanPropertyRowMapper.newInstance(Suggestion.class));
	}

	@Override
	public List<Suggestion> findByQuestId(Integer quest_id) {
		return jdbcTemplate.query("SELECT * FROM suggestion WHERE quest_id = ?", 
				BeanPropertyRowMapper.newInstance(Suggestion.class), quest_id);
	}

	@Override
	public List<Suggestion> findByProductId(Integer product_id) {
		return jdbcTemplate.query("SELECT * FROM suggestion WHERE product_id = ?", 
				BeanPropertyRowMapper.newInstance(Suggestion.class), product_id);
	}

	@Override
	public Integer findMaxSuggestionId() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM suggestion", Integer.class);
	}

	@Override
	public int delete(Suggestion suggestion) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM suggestion WHERE suggestion_id = ?",suggestion.getSuggestion_id());
	}
	
	
	
	
}
