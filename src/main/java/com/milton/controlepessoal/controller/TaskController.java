package com.milton.controlepessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.milton.controlepessoal.entity.Task;
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
