package com.codingdojo.safetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.safetravels.models.Expense;
import com.codingdojo.safetravels.services.ExpenseService;


@Controller
public class HomeController {
	
	private final ExpenseService expenseservice;
	
	@Autowired
	public HomeController(ExpenseService expenseservice) {
		this.expenseservice = expenseservice;
	}
//	***if i need to display all the expenses on a different page
	//display all expense
//	@GetMapping("/")
//	public String showAllExpenses(Model model) {
//		model.addAttribute("expenses", expenseservice.allExpenses());
//		return "dashboard.jsp";
//	}
////	
//	@RequestMapping("/api/books")
//    public List<Expense> showAllBooks() {
//        return bookService.allBooks();
//    }
	
	
//	How to edit/update an expense
	
	
	   
	
	@GetMapping("/editExpense/{id}")
	public String editExpenseForm(@PathVariable("id") Long id, @ModelAttribute("expense")Expense expense, Model model) {
		model.addAttribute("expense", expenseservice.findExpense(id));
		
		return "editExpense.jsp";
		
	}
	
//	Post of edit/update
	@RequestMapping(value="/updatingExpense/{id}", method=RequestMethod.PUT)
	public String updatingExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "editExpense.jsp";
		} else {
			expenseservice.editExpense(expense);
			return "redirect:/";
		}
	}
			

	
	

	//	process to create new expense/ and display all on one index
	@RequestMapping("/")
    public String indexPage(@ModelAttribute("expense")Expense expense, Model model) {
		model.addAttribute("expenses", expenseservice.allExpenses());
    		return "index.jsp";
    
	
    }
	
//process the post to create expense
	@PostMapping("/processExpense")
	public String postingExpense(@Valid @ModelAttribute("expense")Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			expenseservice.createExpense(expense);
			return "redirect:/";
		}
		
	
		
	}
	
}
