package com.milton.controlepessoal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milton.controlepessoal.entity.Task;
import com.milton.controlepessoal.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> findAllTasks() {
		
		return taskRepository.findAll();

	}
}
