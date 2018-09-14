package com.milton.controlepessoal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milton.controlepessoal.entity.Meal;
import com.milton.controlepessoal.repository.MealRepository;

@Service
public class MealService {
	
	@Autowired
	private MealRepository mealRepository;
	
	public List<Meal> listAllMeals(){
		
		List<Meal> meals = mealRepository.findAll();
		
		return meals;
		
	}
	
	public Integer totalProteina() {
		List<Meal> total = listAllMeals();
		
		Integer totalProteina = 0;
		
		
		for (Meal meal : total) {
			totalProteina += meal.getQtdProtein();
			
		}
		
		return totalProteina;
	}
	
	public Integer totalCarbo() {
		List<Meal> total = listAllMeals();
		
		Integer totalCarbo= 0;
		
		for (Meal meal : total) {
			totalCarbo += meal.getQtdCarb();
		}
		
		return totalCarbo;
	}
	
	public Integer totalGordura() {
		List<Meal> total = listAllMeals();
		
		Integer totalGordura= 0;
		
		for (Meal meal : total) {
			totalGordura += meal.getQtdFat();
		}
		
		return totalGordura;
	}

}
