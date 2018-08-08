package com.milton.controlepessoal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milton.controlepessoal.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("tasks")
	public String tasksList(Model model) {
		
		model.addAttribute("tasksList", taskService.findAllTasks());
		
		return "tasks";
		
		
	}

}
