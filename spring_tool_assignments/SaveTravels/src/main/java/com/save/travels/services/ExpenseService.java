package com.save.travels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.save.travels.models.Expense;
import com.save.travels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;
	
//	constructor
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public List<Expense> allExpenses() {
		return (List<Expense>)this.expenseRepo.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return this.expenseRepo.save(expense);
	}
	
	public Expense oneExpense(Long id) {
		return this.expenseRepo.findById(id).orElse(null);
	}
	
	public Expense updateExpense(Expense expense) {
		return this.expenseRepo.save(expense);
	}
	
	public void deleteExpense(Long id) {
		this.expenseRepo.deleteById(id);
	}
	

}


////find all expenses
//public List<Expense> allExpenses() {
//	return (List<Expense>)this.expenseRepo.findAll();
//}
//
////create
//public Expense createExpense(Expense expense) {
//	return this.expenseRepo.save(expense);
//}
//
////Find One
//public Expense oneExpense(Long id) {
//	Optional<Expense> optionalExpense = expenseRepo.findById(id);
//	if(optionalExpense.isPresent()) {
//		return optionalExpense.get();
//	}else {
//		return null;
//	}
//}
//
////Update One
//public Expense updateExpense(Expense expense) {
//	return this.expenseRepo.save(expense);
//}
//
////Delete
//public void deleteExpense(Long id) {
//	this.expenseRepo.deleteById(id);
//}