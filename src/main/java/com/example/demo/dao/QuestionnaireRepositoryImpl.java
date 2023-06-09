package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Questionnaire;

@Repository
public class QuestionnaireRepositoryImpl implements QuestionnaireRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Questionnaire quest) {
		return jdbcTemplate.update("INSERT INTO Questionnaire VALUES(?,?,?,?,?,?)",
				quest.getQuestId(),quest.getClientId(),quest.getPrincipal(),quest.getTargetRate(),quest.getNumOfDays(),quest.getSubmissionTime());
		
	}

	@Override
	public Questionnaire findById(Integer questId) {
		return jdbcTemplate.queryForObject("SELECT * FROM questionnaire WHERE quest_id = ?", BeanPropertyRowMapper.newInstance(Questionnaire.class), questId);
		
	}

	@Override
	public List<Questionnaire> findAll() {
		return jdbcTemplate.query("SELECT * FROM questionnaire", BeanPropertyRowMapper.newInstance(Questionnaire.class));
	}

	@Override
	public List<Questionnaire> findByClientId(Integer clientId) {
		return jdbcTemplate.query("SELECT * FROM questionnaire WHERE client_id = ?", BeanPropertyRowMapper.newInstance(Questionnaire.class), clientId);
	}

	@Override
	public Integer findMaxQuestId() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) from questionnaire", Integer.class);
	}

	@Override
	public int delete(Questionnaire quest) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM questionnaire WHERE quest_id = ?", quest.getQuestId());
	}
	
	
	
	
}
