package com.milton.controlepessoal.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;

	private int qtdProtein;

	private int qtdCarb;

	private int qtdFat;

	private LocalDateTime dthrMeal;

	@Enumerated(EnumType.STRING)
	private CarboDay carboDay;

	public Meal() {

	}

	public Meal(String description, int qtdProtein, int qtdCarb, int qtdFat, LocalDateTime dthrMeal,
			CarboDay carboDay) {
		this.description = description;
		this.qtdProtein = qtdProtein;
		this.qtdCarb = qtdCarb;
		this.qtdFat = qtdFat;
		this.dthrMeal = dthrMeal;
		this.carboDay = carboDay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQtdProtein() {
		return qtdProtein;
	}

	public void setQtdProtein(int qtdProtein) {
		this.qtdProtein = qtdProtein;
	}

	public int getQtdCarb() {
		return qtdCarb;
	}

	public void setQtdCarb(int qtdCarb) {
		this.qtdCarb = qtdCarb;
	}

	public LocalDateTime getDthrMeal() {
		return dthrMeal;
	}

	public void setDthrMeal(LocalDateTime dthrMeal) {
		this.dthrMeal = dthrMeal;
	}

	public CarboDay getCarboDay() {
		return carboDay;
	}

	public void setCarboDay(CarboDay carboDay) {
		this.carboDay = carboDay;
	}

	public int getQtdFat() {
		return qtdFat;
	}

	public void setQtdFat(int qtdFat) {
		this.qtdFat = qtdFat;
	}

}
