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
	public BigDecimal validateRate(String strTarget_rate) throws InvalidInputException {
		// TODO Auto-generated method stub
		BigDecimal target_rate = null;
		try {
			target_rate = new BigDecimal(strTarget_rate);
		} catch (NumberFormatException nfe) {
			throw new InvalidInputException();
		}
		
		return target_rate;
	}

	@Override
	public Integer validateDays(String strNum_of_days) throws InvalidInputException {
		// TODO Auto-generated method stub
		Integer num_of_days = null;
		try {
			num_of_days = Integer.parseInt(strNum_of_days);
		} catch (NumberFormatException nfe) {
			throw new InvalidInputException();
		}
		
		return num_of_days;
	}

	@Override
	public List<Questionnaire> submitQuessionnaire(Integer client_id, BigDecimal principal, BigDecimal target_rate,
			Integer num_of_days) {
		// TODO Auto-generated method stub
		Integer newQuest_id = questRepo.findMaxQuestId()+1;
		Questionnaire quest = new Questionnaire(newQuest_id,client_id,principal,target_rate,num_of_days);
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
		quest.setQuest_id(questRepo.findMaxQuestId()+1);
		return questRepo.save(quest);
	}

	@Override
	public int addSuggestion(Questionnaire quest, Product product) {
		Suggestion suggestion = new Suggestion(suggRepo.findMaxSuggestionId()+1,quest.getQuest_id(),product.getProduct_id());
		return suggRepo.save(suggestion);
	}

	@Override
	public String findEmployeeNameById(Integer employee_id) {
		// TODO Auto-generated method stub
		return employeeRepo.findFullNameById(employee_id);
	}

	@Override
	public List<BankClient> findAllClients() {
		// TODO Auto-generated method stub
		return clientRepo.findAll();
	}

	@Override
	public BankClient findClientById(Integer client_id) {
		// TODO Auto-generated method stub
		return clientRepo.findById(client_id);
	}

	@Override
	public List<Questionnaire> findQuestionnaireByClientId(Integer client_id) {
		// TODO Auto-generated method stub
		return questRepo.findByClientId(client_id);
	}

	@Override
	public List<Suggestion> findSuggestionByQuestId(Integer quest_id) {
		// TODO Auto-generated method stub
		return suggRepo.findByQuestId(quest_id);
	}
	
	@Override
	public Product findProductById(Integer product_id) {
		// TODO Auto-generated method stub
		return productRepo.findById(product_id);
	}

	@Override
	public List<Product> findAllProductsByQuestId(Integer quest_id) {
		// TODO Auto-generated method stub
		
		List<Suggestion> suggList = findSuggestionByQuestId(quest_id);
		
		List<Product> productList = new ArrayList<Product>();
		for (Suggestion sugg : suggList) {
			productList.add(findProductById(sugg.getProduct_id()));
		}

		return productList;
	}

	@Override
	public Map<Questionnaire, List<Product>> findAllProductsQuestsByClientId(Integer client_id) {
		// TODO Auto-generated method stub
		
		Map<Questionnaire, List<Product>> questProdMap = new TreeMap<Questionnaire, List<Product>>( (q1,q2) -> q2.getQuest_id().compareTo(q1.getQuest_id()) );

		List<Questionnaire> questList = findQuestionnaireByClientId(client_id);
		for (Questionnaire q: questList) {
			questProdMap.put(q, findAllProductsByQuestId(q.getQuest_id()));
		}
		return questProdMap;
	}
	
	
	

}
