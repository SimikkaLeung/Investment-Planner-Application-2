package com.example.demo.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.BankClientRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.QuestionnaireRepository;
import com.example.demo.dao.SuggestionRepository;
import com.example.demo.exceptions.InvalidInputException;
import com.example.demo.models.BankClient;
import com.example.demo.models.Product;
import com.example.demo.models.Questionnaire;
import com.example.demo.models.Suggestion;

public interface InvestmentPlannerService {
	
	public List<Product> findAllProducts();
	public BigDecimal validatePrincipal(String strPrincipal) throws InvalidInputException;
	public BigDecimal validateRate(String strTarget_rate) throws InvalidInputException;
	public Integer validateDays(String strNum_of_days) throws InvalidInputException;
	public List<Questionnaire> submitQuessionnaire(Integer client_id, BigDecimal principal, BigDecimal target_rate, Integer num_of_days);
	public List<Product> findProductsByCriteria(Questionnaire quest);
	
	public int addQuestionnaire(Questionnaire quest);
	public int addSuggestion(Questionnaire quest, Product product);
	public String findEmployeeNameById(Integer employee_id);
	public List<BankClient> findAllClients();
	public BankClient findClientById(Integer client_id);
	public List<Questionnaire> findQuestionnaireByClientId(Integer client_id);
	public List<Suggestion> findSuggestionByQuestId(Integer quest_id);
	public Product findProductById(Integer product_id);
	public List<Product> findAllProductsByQuestId(Integer quest_id);
	public Map<Questionnaire, List<Product>> findAllProductsQuestsByClientId(Integer client_id);
	
}
