package com.milton.controlepessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milton.controlepessoal.entity.Meal;
import com.milton.controlepessoal.service.MealService;

@Controller
public class MealController {
	
	@Autowired
	private MealService mealService;
	
	@RequestMapping("meals")
	public String listMeals(Model model) {
		
		List<Meal> listAllMeals = mealService.listAllMeals();
		model.addAttribute("mealsList", listAllMeals);
		
		
		model.addAttribute("totalProteina", mealService.totalProteina());
		model.addAttribute("totalCarbo", mealService.totalCarbo());
		model.addAttribute("totalGordura", mealService.totalGordura());
		
		return "meals";
		
	}

}
