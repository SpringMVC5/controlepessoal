package com.milton.controlepessoal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milton.controlepessoal.entity.CarboDay;
import com.milton.controlepessoal.entity.Meal;
import com.milton.controlepessoal.repository.MealRepository;

@Service
public class MealService {
	
	@Autowired
	private MealRepository mealRepository;
	
	public List<Meal> listHighCarbMeal(){
		
		List<Meal> meals = mealRepository.findByCarboDay(CarboDay.Alto);
		
		return meals;
		
	}
	
	public List<Meal> listMediumCarbMeal(){
		List<Meal> mealsMediumCarb = mealRepository.findByCarboDay(CarboDay.Médio);
		
		return mealsMediumCarb;
	}
	
	public List<Meal> listZeroCarbMeal(){
		List<Meal> mealsZeroCarb = mealRepository.findByCarboDay(CarboDay.Zero);
		
		return mealsZeroCarb;
	}
	
	public Integer totalProteina() {
		List<Meal> total = listHighCarbMeal();
		
		Integer totalProteina = 0;
		
		
		for (Meal meal : total) {
			totalProteina += meal.getQtdProtein();
			
		}
		
		return totalProteina;
	}
	
	public Integer totalCarbo() {
		List<Meal> total = listHighCarbMeal();
		
		Integer totalCarbo= 0;
		
		for (Meal meal : total) {
			totalCarbo += meal.getQtdCarb();
		}
		
		return totalCarbo;
	}
	
	public Integer totalGordura() {
		List<Meal> total = listHighCarbMeal();
		
		Integer totalGordura= 0;
		
		for (Meal meal : total) {
			totalGordura += meal.getQtdFat();
		}
		
		return totalGordura;
	}

}
