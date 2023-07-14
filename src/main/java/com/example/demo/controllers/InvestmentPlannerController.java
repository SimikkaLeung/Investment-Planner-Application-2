package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.BankClient;
import com.example.demo.models.Product;
import com.example.demo.models.Questionnaire;
import com.example.demo.models.Suggestion;
import com.example.demo.models.WebAccount;
import com.example.demo.services.InvestmentPlannerSecurityService;
import com.example.demo.services.InvestmentPlannerService;

@Controller
public class InvestmentPlannerController {
	
	@Autowired
	InvestmentPlannerService myService;
	@Autowired
	InvestmentPlannerSecurityService securityService;
	
	
	
	
	@GetMapping("/products")
	public String displayAllProducts(Model model){
		List<Product> productList = myService.findAllProducts();
		model.addAttribute("productList", productList.toArray());
		return "products";
	}
		
	// Display the questionnaire
	@GetMapping("/client/investmentplanner")
	public String showForm(Model model){

        Questionnaire quest = new Questionnaire();        

        model.addAttribute("quest", quest);
		return "questionnaire";
	}
	
	// Search for the products according to the client's answers and
	// send the questionnaire and suggestion data back to the database
	
	@PostMapping("/client/investmentplanner")
	public String submitQuessionnaire(Model model, @ModelAttribute("quest") @Valid Questionnaire quest, BindingResult result){
//		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//		Set<ConstraintViolation<Questionnaire>> errors = validator.validate(quest);
		if (result.hasErrors()) {
			return "questionnaire";
		}
		
		BankClient client = securityService.findClientbyAccountId();		// Get the current client data
        quest.setClientId(client.getClientId());
		myService.addQuestionnaire(quest);
		List<Product> productList = myService.findProductsByCriteria(quest);
		productList.stream().forEach((p) -> myService.addSuggestion(quest,p));
		model.addAttribute("productList", productList.toArray());
		return "suggestions";
	}
	
	// Display the client basic info, and allow the employee to select the id
	// of a client to view their questionnaire responses.
	@GetMapping("/employee/allclients")
	public String browseResults(Model model){

		BankClient selectedClient = new BankClient();
		model.addAttribute("selectedClient",selectedClient);
		model.addAttribute("allClients",myService.findAllClients());

		return "allclients";
	}
	
	// View a client's questionnaire responses and the product suggestions.
	@PostMapping("/employee/clientdetails")
	public String browseClientResponses(Model model, @ModelAttribute("selectedClient") BankClient selectedClient){

		selectedClient = myService.findClientById(selectedClient.getClientId());
		model.addAttribute("selectedClient",selectedClient);
		Map<Questionnaire, List<Product>> questProdMap = myService.findAllProductsQuestsByClientId(selectedClient.getClientId());
		model.addAttribute("questProdMap",questProdMap);
		return "clientresponses";
	}
	
	
}
