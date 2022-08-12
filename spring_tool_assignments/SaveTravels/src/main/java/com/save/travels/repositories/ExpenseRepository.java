package com.save.travels.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.save.travels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
}
