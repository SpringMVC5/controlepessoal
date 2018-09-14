package com.milton.controlepessoal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.milton.controlepessoal.entity.Task;

@Controller
public class TaskFormController {
	
	@GetMapping("/task")
	public String getTask(Model model) {
		
		model.addAttribute("task", new Task());
		
		return "task";
		
	}
	
	@PostMapping("/task")
	public String submitTask(@ModelAttribute Task task) {
		return "result";
	}

}
