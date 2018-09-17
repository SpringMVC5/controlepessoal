package com.milton.controlepessoal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milton.controlepessoal.entity.Manipulados;
import com.milton.controlepessoal.repository.ManipuladosRepository;

@Service
public class ManipuladosService {
	
	@Autowired
	private ManipuladosRepository manipuladosRepository;
	
	public List<Manipulados> listaManipulados(){
		
		List<Manipulados> listaManipulados = manipuladosRepository.findAll();
		
		return listaManipulados;
		
	}

}
