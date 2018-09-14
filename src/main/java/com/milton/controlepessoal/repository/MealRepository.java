package com.milton.controlepessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milton.controlepessoal.entity.CarboDay;
import com.milton.controlepessoal.entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>{
	
	public List<Meal> findByCarboDay(CarboDay carboDay);

}
