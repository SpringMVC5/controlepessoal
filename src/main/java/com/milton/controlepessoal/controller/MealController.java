package com.milton.controlepessoal.controller;

import java.util.List;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.milton.controlepessoal.entity.Meal;
import com.milton.controlepessoal.service.MealService;

@Controller
public class MealController {
	
	@Autowired
	private MealService mealService;
	
	@RequestMapping("meals")
	public String listMeals(Model model) {
		
		List<Meal> listHighCarbMeal = mealService.listHighCarbMeal();
		model.addAttribute("highCarbMealList", listHighCarbMeal);
		
		List<Meal> listMediumCarbMeal = mealService.listMediumCarbMeal();
		model.addAttribute("mediumCarbMealList", listMediumCarbMeal);
		
		List<Meal> listZeroCarbMeal = mealService.listZeroCarbMeal();
		model.addAttribute("zeroCarbMealList", listZeroCarbMeal);
		
		model.addAttribute("totalProteina", mealService.totalProteina());
		model.addAttribute("totalCarbo", mealService.totalCarbo());
		model.addAttribute("totalGordura", mealService.totalGordura());
		
		return "meals";
		
	}
	
	@RequestMapping("mediumCarbMeals")
	public String mediumCarbMeals(Model model) {
		
		List<Meal> listMediumCarbMeal = mealService.listMediumCarbMeal();
		
		model.addAttribute("mediumCarbMealList", listMediumCarbMeal);
		
		return "mediumCarbMeal";
		
	}
	
	@RequestMapping("highCarbMeals")
	public String highCarbMeals(Model model) {
		
		List<Meal> listHighCarbMeal = mealService.listHighCarbMeal();
		
		model.addAttribute("highCarbMealList", listHighCarbMeal);
		
		return "highCarbMeal";
		
	}
	
	@RequestMapping("zeroCarbMeals")
	public String zeroCarbMeals(Model model) {
		
		List<Meal> listZeroCarbMeal = mealService.listZeroCarbMeal();
		
		model.addAttribute("zeroCarbMealList", listZeroCarbMeal);
		
		return "zeroCarbMeal";
		
		
	}
	
	@RequestMapping({"offMeals","off"})
	public String offMeals(Model model) {
		
		List<Meal> listOffMeal = mealService.listOffMeal();
		
		model.addAttribute("offMealList",listOffMeal);
		
		return "offMeal";
	}

}
