package com.milton.controlepessoal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.milton.controlepessoal.entity.Task;
import com.milton.controlepessoal.service.TaskService;

@RestController
public class TaskHTTPController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="listaTask",method=RequestMethod.GET)
	public List<Task> listaTaskGet(){
		
		return taskService.findAllTasks();
		
	}
	
	@RequestMapping(value="listaTask/{task}")
	public List<Task> listaTaskParametro(@PathVariable String task){
		
		List<Task> findAllTasks = taskService.findAllTasks();
		
		List<Task> listaFiltrada = new ArrayList<>();
		
		for (Task task2 : findAllTasks) {
			
			if(task2.getDescricaoTarefa().equalsIgnoreCase(task))
				listaFiltrada.add(task2);
			
		}
		
		if(listaFiltrada.isEmpty())
			System.out.println("Nenhuma tarefa encontrada com o filtro desejado!");
		
		return listaFiltrada;
		
	}
	
	@RequestMapping(value="postTask", method=RequestMethod.POST)
	public Task taskPost(@RequestBody Task task) {
		System.out.println("Post acessado com sucesso");
		//formato de envio Json post
//		{
//			"descricaoTarefa":"testeTarefa",
//			"dthrInclusao":"teste@gmail.com",
//			"prioridadeTarefa":"teste"
//
//		}
		return task;
		
	}

}
