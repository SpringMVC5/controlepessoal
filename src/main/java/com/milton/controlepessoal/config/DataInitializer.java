package com.milton.controlepessoal.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.milton.controlepessoal.entity.CarboDay;
import com.milton.controlepessoal.entity.Manipulados;
import com.milton.controlepessoal.entity.Meal;
import com.milton.controlepessoal.entity.Task;
import com.milton.controlepessoal.entity.TaskPriority;
import com.milton.controlepessoal.repository.ManipuladosRepository;
import com.milton.controlepessoal.repository.MealRepository;
import com.milton.controlepessoal.repository.TaskRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private MealRepository mealRepository;
	
	@Autowired
	private ManipuladosRepository manipuladosRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Task task = new Task("tarefa1", LocalDateTime.now(), TaskPriority.Baixa);
		Task task2 = new Task("testandoTarefa", LocalDateTime.now(), TaskPriority.Média);
		
		taskRepository.save(task);
		taskRepository.save(task2);
		
		System.out.println(task.getDescricaoTarefa());
		

		System.out.println("Deu certo!");
		
		Task findByDescricaoTarefa = taskRepository.findByDescricaoTarefa("testandoTarefa");
		System.out.println(findByDescricaoTarefa);
		
		
		// Popular dados Meal

		createMeal("Vitamina de Leite Desnatado, aveia, morango e Whey",30,80,0,LocalDateTime.of(2018, 9, 9, 11, 0, 0),CarboDay.Alto);
		createMeal("Omelete 5 claras e 2 gemas",30,0,0,LocalDateTime.of(2018, 9, 9, 14, 0, 0),CarboDay.Alto);
		createMeal("Arroz Integral / Macarrão Integral e Frango",200,150,0,LocalDateTime.of(2018, 9, 9, 16, 30, 0),CarboDay.Alto);
		createMeal("Batata Doce com Whey",30,150,0,LocalDateTime.of(2018, 9, 9, 18, 30, 0),CarboDay.Alto);
		createMeal("Arroz Integral / Macarrão Integral e Carne",200,150,0,LocalDateTime.of(2018, 9, 9, 20, 30, 0),CarboDay.Alto);
		createMeal("Omelete 6 ovos ou Frango ou Carne",200,0,30,LocalDateTime.of(2018, 9, 9, 23, 30, 0),CarboDay.Alto);
		
		//Carbo Médio

		createMeal("Vitamina de Leite Desnatado, aveia, morango e Whey",30,60,0,LocalDateTime.of(2018, 9, 9, 11, 0, 0),CarboDay.Médio);
		createMeal("Omelete 5 claras e 2 gemas",30,0,0,LocalDateTime.of(2018, 9, 9, 14, 0, 0),CarboDay.Médio);
		createMeal("Arroz Integral / Macarrão Integral e Frango",200,100,0,LocalDateTime.of(2018, 9, 9, 16, 30, 0),CarboDay.Médio);
		createMeal("Batata Doce com Whey",30,100,0,LocalDateTime.of(2018, 9, 9, 18, 30, 0),CarboDay.Médio);
		createMeal("Arroz Integral / Macarrão Integral e Carne",200,100,0,LocalDateTime.of(2018, 9, 9, 20, 30, 0),CarboDay.Médio);
		createMeal("Omelete 6 ovos ou Frango ou Carne",200,0,30,LocalDateTime.of(2018, 9, 9, 23, 30, 0),CarboDay.Médio);
		
		//Carbo Zero

	    createMeal("Omelete 6 ovos",40,0,0,LocalDateTime.of(2018, 9, 9, 11, 0, 0),CarboDay.Zero);
	    createMeal("Carne, Frango ou Peixe",200,0,0,LocalDateTime.of(2018, 9, 9, 14, 0, 0),CarboDay.Zero);
	    createMeal("Omelete 4 ovos,Carne, Peixe ou Frango",200,0,0,LocalDateTime.of(2018, 9, 9, 16, 30, 0),CarboDay.Zero);
	    createMeal("Carne, Frango ou Peixe",200,0,0,LocalDateTime.of(2018, 9, 9, 18, 30, 0),CarboDay.Zero);
	    createMeal("Carne, Frango ou Peixe",200,0,0,LocalDateTime.of(2018, 9, 9, 20, 30, 0),CarboDay.Zero);
	    createMeal("Omeletse 6 ovos",40,0,30,LocalDateTime.of(2018, 9, 9, 23, 30, 0),CarboDay.Zero);
		
		// Busca utilizando métodos prontos da JPA, no caso o findBy*NomeAtributo
		List<Meal> findByCarboDay = mealRepository.findByCarboDay(CarboDay.Alto);
		for (Meal meal7 : findByCarboDay) {
			System.out.println(meal7.getDescription());
		}
		
		// Popular Manipulados
		int mesAtual = LocalDateTime.now().getMonth().getValue();
		int diaAtual = LocalDateTime.now().getDayOfMonth();
		System.out.println(diaAtual);
		
		
		createManipulados("Cafeína", 1, 200, LocalDateTime.of (2018, mesAtual, diaAtual, 7, 30, 0));
		createManipulados("Ioimbina", 1, 10, LocalDateTime.of (2018, mesAtual, diaAtual, 7, 30, 0));
		createManipulados("L-Carnitina", 1, 500, LocalDateTime.of (2018, mesAtual, diaAtual, 7, 30, 0));
		createManipulados("Gaba", 1, 200, LocalDateTime.of    (2018, mesAtual, diaAtual, 7, 30, 0));
		createManipulados("Cafeína", 1, 200, LocalDateTime.of (2018, mesAtual, diaAtual, 15, 00, 0));
		createManipulados("Ioimbina", 1, 10, LocalDateTime.of (2018, mesAtual, diaAtual, 15, 00, 0));
		createManipulados("L-Carnitina", 1, 500, LocalDateTime.of (2018, mesAtual, diaAtual, 15, 00, 0));
		createManipulados("5 HTP", 1, 100, LocalDateTime.of   (2018, mesAtual, diaAtual, 23, 30, 0));
		createManipulados("Gaba", 1, 200, LocalDateTime.of    (2018, mesAtual, diaAtual, 23, 30, 0));
		createManipulados("Melatonina", 1, 3, LocalDateTime.of(2018, mesAtual, diaAtual, 23, 30, 0));
		
	}
	
	public void createMeal(String descricao, Integer qtdProtein, Integer qtdCarb,Integer qtdFat, LocalDateTime dthrMeal, CarboDay carboDay) {
		
		Meal meal = new Meal(descricao, qtdProtein, qtdCarb, qtdFat, dthrMeal, carboDay);
		
		mealRepository.save(meal);
		
	}
	
	public void createManipulados(String nome, Integer quantidade, Integer dosagem, LocalDateTime dthrUse) {
		
		Manipulados manipulados = new Manipulados(nome,quantidade,dosagem,dthrUse);
		
		manipuladosRepository.save(manipulados);
		
		
	}

}
