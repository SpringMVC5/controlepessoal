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
		
		int mesAtual = LocalDateTime.now().getMonth().getValue();
		int diaAtual = LocalDateTime.now().getDayOfMonth();
		int anoAtual = LocalDateTime.now().getYear();
		
		
		createTask("Comprar Tênis para Trabalhar", LocalDateTime.now(), TaskPriority.Baixa);
		createTask("Comprar Complexo Digestivo", LocalDateTime.now(), TaskPriority.Alta);
		createTask("Comprar Leite e coisas do Guh", LocalDateTime.now(), TaskPriority.Alta);
		createTask("Comprar coisas de Mercado", LocalDateTime.now(), TaskPriority.Alta);
		createTask("Marcar consulta Médico Esportivo", LocalDateTime.now(), TaskPriority.Média);
//		createTask("Transferir Dinheiro Paula", LocalDateTime.of(anoAtual, mesAtual, 10, 8, 0, 0), TaskPriority.Alta);
//		createTask("Transferir Dinheiro Má Vitaminas", LocalDateTime.of(anoAtual, mesAtual, 10, 8, 0, 0), TaskPriority.Alta);
		
		

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

	    createMeal("Omelete 6 ovos",40,0,0,LocalDateTime.of(2018, 9, 9, 7, 15, 0),CarboDay.Zero);
	    createMeal("Carne, Frango ou Peixe",200,0,0,LocalDateTime.of(2018, 9, 9, 9, 50, 0),CarboDay.Zero);
	    createMeal("Omelete 4 ovos,Carne, Peixe ou Frango",200,0,0,LocalDateTime.of(2018, 9, 9, 12, 20, 0),CarboDay.Zero);
	    createMeal("Carne, Frango ou Peixe",200,0,0,LocalDateTime.of(2018, 9, 9, 16, 0, 0),CarboDay.Zero);
	    createMeal("Carne, Frango ou Peixe",200,0,0,LocalDateTime.of(2018, 9, 9, 20, 30, 0),CarboDay.Zero);
	    createMeal("Omelete 6 ovos + Pasta de Amendoim",40,0,30,LocalDateTime.of(2018, 9, 9, 23, 0, 0),CarboDay.Zero);
	    
		//Off Season

	    createMeal("Vitamina de Leite Desnatado, aveia, morango/Banana e 2,5 Scoops Whey",45,120,0,LocalDateTime.of(anoAtual, mesAtual, diaAtual, 7, 30, 0),CarboDay.Off);
	    createMeal("Omelete 6 ovos (3 gemas + aveia)",35,60,0,LocalDateTime.of(anoAtual, mesAtual, diaAtual, 9, 50, 0),CarboDay.Off);
	    createMeal("Arroz Branco + Frango + Legumes",250,400,0,LocalDateTime.of(anoAtual, mesAtual, diaAtual, 12, 20, 0),CarboDay.Off);
	    createMeal("Batata Doce / Batata Inglesa + 3 scoops whey",45,350,0,LocalDateTime.of(anoAtual, mesAtual, diaAtual, 16, 0, 0),CarboDay.Off);
	    createMeal("Pré Treino: Banana",0,3,0,LocalDateTime.of(anoAtual, mesAtual, diaAtual, 18, 00, 0),CarboDay.Off);
	    createMeal("Pós Treino: 2 Scoops whey + Arroz Branco e Carne Vermelha",30,400,30,LocalDateTime.of(anoAtual, mesAtual, diaAtual, 21, 30, 0),CarboDay.Off);
	    createMeal("Pasta de Amendoim",0,0,30,LocalDateTime.of(anoAtual, mesAtual, diaAtual, 22, 0, 0),CarboDay.Off);
		
		// Busca utilizando métodos prontos da JPA, no caso o findBy*NomeAtributo
		List<Meal> findByCarboDay = mealRepository.findByCarboDay(CarboDay.Alto);
		for (Meal meal7 : findByCarboDay) {
			System.out.println(meal7.getDescription());
		}
		
		// Popular Manipulados
		
		
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

	public void createTask(String descTarefa, LocalDateTime dthrTarefa, TaskPriority taskPriority) {
		
		Task task = new Task(descTarefa, dthrTarefa, taskPriority);
		
		taskRepository.save(task);
		
	}
	
	

}
