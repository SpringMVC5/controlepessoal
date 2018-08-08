package com.milton.controlepessoal.config;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.milton.controlepessoal.entity.Task;
import com.milton.controlepessoal.entity.TaskPriority;
import com.milton.controlepessoal.repository.TaskRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private TaskRepository taskRepository;

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

	}

}
