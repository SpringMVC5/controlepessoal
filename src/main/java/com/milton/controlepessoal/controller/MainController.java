package com.milton.controlepessoal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String goToApp() {
		
		return "index.html";
	}

}
