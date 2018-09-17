package com.milton.controlepessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milton.controlepessoal.entity.Manipulados;
import com.milton.controlepessoal.service.ManipuladosService;

@Controller
public class ManipuladosController {
	
	@Autowired
	private ManipuladosService manipuladosService;
	
	@RequestMapping("manipulados")
	public String listaManipulados(Model model) {
		
		List<Manipulados> listaManipulados = manipuladosService.listaManipulados();
		
		model.addAttribute("manipuladosList", listaManipulados);
		
		return "manipulateds";
		
	}

}
