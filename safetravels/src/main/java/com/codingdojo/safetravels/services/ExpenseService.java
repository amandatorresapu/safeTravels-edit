package com.codingdojo.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.safetravels.models.Expense;
import com.codingdojo.safetravels.repositories.SafeTravelsRepository;

@Service
public class ExpenseService {
	
	private final SafeTravelsRepository safetravelsRepository;
	
	@Autowired
	public ExpenseService(SafeTravelsRepository safetravelsRepository) {
		this.safetravelsRepository = safetravelsRepository;
	}
	
//	 Create book 
	 public Expense createExpense(Expense e) {
	        return safetravelsRepository.save(e);
	    }
	 
	  // returns all the books
	    public List<Expense> allExpenses() {
	        return safetravelsRepository.findAll();
	    }
	    
//	    update expense
	    public Expense editExpense(Expense e) {
	        return safetravelsRepository.save(e);
	    }
	    
	    //Find one expense
	    public Expense findExpense(Long id) {
	    	Optional<Expense> oneExpense = safetravelsRepository.findById(id);
	    	if(oneExpense.isPresent()) {
	    		return oneExpense.get();
	    	} else {
	    		return null;
	    	}
	    	
	    	
	    }

}
