package com.example.demo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BankClientRepository;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.QuestionnaireRepository;
import com.example.demo.dao.SuggestionRepository;
import com.example.demo.exceptions.InvalidInputException;
import com.example.demo.models.BankClient;
import com.example.demo.models.Product;
import com.example.demo.models.Questionnaire;
import com.example.demo.models.Suggestion;

@Service
public class InvestmentPlannerServiceImpl implements InvestmentPlannerService {
	
	// This service performs the CRUD actions via repositories.
	
	@Autowired
	private BankClientRepository clientRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private QuestionnaireRepository questRepo;
	@Autowired
	private SuggestionRepository suggRepo;
	@Autowired
	private EmployeeRepository employeeRepo;
	
	
	
	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public BigDecimal validatePrincipal(String strPrincipal) throws InvalidInputException {
		// TODO Auto-generated method stub
		BigDecimal principal = null;
		try {
			principal = new BigDecimal(strPrincipal);
		} catch (NumberFormatException nfe) {
			throw new InvalidInputException();
		}
		
		return principal;
	}

	@Override
	public BigDecimal validateRate(String strTargetRate) throws InvalidInputException {
		// TODO Auto-generated method stub
		BigDecimal targetRate = null;
		try {
			targetRate = new BigDecimal(strTargetRate);
		} catch (NumberFormatException nfe) {
			throw new InvalidInputException();
		}
		
		return targetRate;
	}

	@Override
	public Integer validateDays(String strNumOfDays) throws InvalidInputException {
		// TODO Auto-generated method stub
		Integer numOfDays = null;
		try {
			numOfDays = Integer.parseInt(strNumOfDays);
		} catch (NumberFormatException nfe) {
			throw new InvalidInputException();
		}
		
		return numOfDays;
	}

	@Override
	public List<Questionnaire> submitQuessionnaire(Integer clientId, BigDecimal principal, BigDecimal targetRate,
			Integer numOfDays) {
		// TODO Auto-generated method stub
		Integer newQuestId = questRepo.findMaxQuestId()+1;
		Questionnaire quest = new Questionnaire(newQuestId,clientId,principal,targetRate,numOfDays);
		questRepo.save(quest);
		return null;
	}

	@Override
	public List<Product> findProductsByCriteria(Questionnaire quest) {
		// TODO Auto-generated method stub
		
		return productRepo.findByCriteria(quest);
	}

	@Override
	public int addQuestionnaire(Questionnaire quest) {
		// TODO Auto-generated method stub
		quest.setQuestId(questRepo.findMaxQuestId()+1);
		return questRepo.save(quest);
	}

	@Override
	public int addSuggestion(Questionnaire quest, Product product) {
		Suggestion suggestion = new Suggestion(suggRepo.findMaxSuggestionId()+1,quest.getQuestId(),product.getProductId());
		return suggRepo.save(suggestion);
	}

	@Override
	public String findEmployeeNameById(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeRepo.findFullNameById(employeeId);
	}

	@Override
	public List<BankClient> findAllClients() {
		// TODO Auto-generated method stub
		return clientRepo.findAll();
	}

	@Override
	public BankClient findClientById(Integer clientId) {
		// TODO Auto-generated method stub
		return clientRepo.findById(clientId);
	}

	@Override
	public List<Questionnaire> findQuestionnaireByClientId(Integer clientId) {
		// TODO Auto-generated method stub
		return questRepo.findByClientId(clientId);
	}

	@Override
	public List<Suggestion> findSuggestionByQuestId(Integer questId) {
		// TODO Auto-generated method stub
		return suggRepo.findByQuestId(questId);
	}
	
	@Override
	public Product findProductById(Integer productId) {
		// TODO Auto-generated method stub
		return productRepo.findById(productId);
	}

	@Override
	public List<Product> findAllProductsByQuestId(Integer questId) {
		// TODO Auto-generated method stub
		
		List<Suggestion> suggList = findSuggestionByQuestId(questId);
		
		List<Product> productList = new ArrayList<Product>();
		for (Suggestion sugg : suggList) {
			productList.add(findProductById(sugg.getProductId()));
		}

		return productList;
	}

	@Override
	public Map<Questionnaire, List<Product>> findAllProductsQuestsByClientId(Integer clientId) {
		// TODO Auto-generated method stub
		
		Map<Questionnaire, List<Product>> questProdMap = new TreeMap<Questionnaire, List<Product>>( (q1,q2) -> q2.getQuestId().compareTo(q1.getQuestId()) );

		List<Questionnaire> questList = findQuestionnaireByClientId(clientId);
		for (Questionnaire q: questList) {
			questProdMap.put(q, findAllProductsByQuestId(q.getQuestId()));
		}
		return questProdMap;
	}
	
	
	

}
