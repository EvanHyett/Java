package com.save.travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.save.travels.models.Expense;
import com.save.travels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Expense> allExpenses = this.expenseService.allExpenses();
		model.addAttribute("allExpenses", allExpenses);
		model.addAttribute("expense", new Expense());
		return "index.jsp";
	}
	
//	GET ONE
	@RequestMapping("/expense/{id}") 
	public String getOne(@PathVariable("id") Long id, Model model) {
		Expense expense = this.expenseService.oneExpense(id);
		model.addAttribute("expense", expense);
		return "oneItem.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		expense.toStringTo();
		if(result.hasErrors()) {
			List<Expense> allExpenses = this.expenseService.allExpenses();
			model.addAttribute("allExpenses", allExpenses);
			return "index.jsp";
		}else {
			this.expenseService.createExpense(expense);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = this.expenseService.oneExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}

	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		expense.toStringTo();
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			this.expenseService.updateExpense(expense);
			return "redirect:/";
		}
		
	}
	
	
//	@RequestMapping("/edit/{id}")
//	public String edit(@PathVariable("id") Long id, Model model) {
//		Expense expense = this.expenseService.oneExpense(id);
//		model.addAttribute("expense", expense);
//		return "edit.jsp";
//	}
//	
//	@PutMapping("/edit/{id}")
//	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
//		if(result.hasErrors()) {
//			return "edit.jsp";
//		}else {
//			this.expenseService.updateExpense(expense);
//			return "redirect:/";
//		}
//	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.expenseService.deleteExpense(id);
		return "redirect:/";
	}
	
}


//@Autowired
//private ExpenseService expenseService;
//
//@GetMapping("/")
//public String index(Model model) {
//	List<Expense> allExpenses = expenseService.allExpenses();
//	model.addAttribute("expense", new Expense());
//	model.addAttribute("allExpenses", allExpenses);
//	return "index.jsp";
//}
//
//@PostMapping("/")
//public String createExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
//	if(result.hasErrors()) {
//		return "index.jsp";
//	}else {
//		expenseService.createExpense(expense);
//		return "redirect:/";
//	}
//}
//
//@GetMapping("/edit/{id}")
//public String edit(@PathVariable("id") Long id, Model model) {
//	Expense foundExpense = expenseService.oneExpense(id);
//	model.addAttribute("expense", foundExpense);
//	return "edit.jsp";
//}
//
//@PutMapping("/update/{id}")
//public String editExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
//	if(result.hasErrors()) {
//		return "edit.jsp";
//	}else {
//		expenseService.updateExpense(expense);
//		return "redirect:/";
//	}
//}