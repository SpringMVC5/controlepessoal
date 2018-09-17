package com.milton.controlepessoal.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manipulados {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Integer quantidade;

	private Integer dosagem;

	private LocalDateTime dthrUse;

	public Manipulados() {

	}

	public Manipulados(String name, Integer quantidade, Integer dosagem, LocalDateTime dthrUse) {
		this.name = name;
		this.quantidade = quantidade;
		this.dosagem = dosagem;
		this.dthrUse = dthrUse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getDosagem() {
		return dosagem;
	}

	public void setDosagem(Integer dosagem) {
		this.dosagem = dosagem;
	}

	public LocalDateTime getDthrUse() {
		return dthrUse;
	}

	public void setDthrUse(LocalDateTime dthrUse) {
		this.dthrUse = dthrUse;
	}

}
