package com.save.travels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.save.travels.models.Expense;
import com.save.travels.services.ExpenseService;

@RestController
public class ExpenseAPI {
	private final ExpenseService expenseService;
	
	public ExpenseAPI(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping("/api/")
	public List<Expense> index(){
		return this.expenseService.allExpenses();
	}
}
