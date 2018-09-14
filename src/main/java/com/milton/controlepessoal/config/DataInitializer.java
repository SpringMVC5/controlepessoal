package com.milton.controlepessoal.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.milton.controlepessoal.entity.CarboDay;
import com.milton.controlepessoal.entity.Meal;
import com.milton.controlepessoal.entity.Task;
import com.milton.controlepessoal.entity.TaskPriority;
import com.milton.controlepessoal.repository.MealRepository;
import com.milton.controlepessoal.repository.TaskRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private MealRepository mealRepository;

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
		
		Meal meal = new Meal("Vitamina de Leite Desnatado, aveia, morango e Whey",30,80,0,LocalDateTime.of(2018, 9, 9, 11, 0, 0),CarboDay.Alto);
		Meal meal2 = new Meal("Omelete 5 claras e 2 gemas",30,0,0,LocalDateTime.of(2018, 9, 9, 14, 0, 0),CarboDay.Alto);
		Meal meal3 = new Meal("Arroz Integral / Macarrão Integral e Frango",200,150,0,LocalDateTime.of(2018, 9, 9, 16, 30, 0),CarboDay.Alto);
		Meal meal4 = new Meal("Batata Doce com Whey",30,150,0,LocalDateTime.of(2018, 9, 9, 18, 30, 0),CarboDay.Alto);
		Meal meal5 = new Meal("Arroz Integral / Macarrão Integral e Carne",200,150,0,LocalDateTime.of(2018, 9, 9, 20, 30, 0),CarboDay.Alto);
		Meal meal6 = new Meal("Omlete 6 ovos ou Frango ou Carne",200,0,30,LocalDateTime.of(2018, 9, 9, 23, 30, 0),CarboDay.Alto);
		
		
		mealRepository.save(meal);
		mealRepository.save(meal2);
		mealRepository.save(meal3);
		mealRepository.save(meal4);
		mealRepository.save(meal5);
		mealRepository.save(meal6);
		
		
		// Busca utilizando métodos prontos da JPA, no caso o findBy*NomeAtributo
		List<Meal> findByCarboDay = mealRepository.findByCarboDay(CarboDay.Alto);
		for (Meal meal7 : findByCarboDay) {
			System.out.println(meal7.getDescription());
		}
		
	}

}
