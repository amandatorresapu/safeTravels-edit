package com.codingdojo.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.safetravels.models.Expense;



@Repository
public interface SafeTravelsRepository extends CrudRepository <Expense, Long> {
	
	 List<Expense> findAll();

}
