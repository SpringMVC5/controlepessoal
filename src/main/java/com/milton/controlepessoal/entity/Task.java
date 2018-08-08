package com.milton.controlepessoal.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String descricaoTarefa;
	private LocalDateTime dthrInclusao;
	@Enumerated(EnumType.STRING)
	private TaskPriority prioridadeTarefa;

	public Task() {
	}

	public Task(String descricaoTarefa, LocalDateTime dthrInclusao, TaskPriority prioridadeTarefa) {
		this.descricaoTarefa = descricaoTarefa;
		this.dthrInclusao = dthrInclusao;
		this.prioridadeTarefa = prioridadeTarefa;
	}
	
	@Override
	public String toString() {
		return id +  " " + descricaoTarefa + " " + dthrInclusao + " " + prioridadeTarefa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public LocalDateTime getDthrInclusao() {
		return dthrInclusao;
	}

	public void setDthrInclusao(LocalDateTime dthrInclusao) {
		this.dthrInclusao = dthrInclusao;
	}

	public TaskPriority getPrioridadeTarefa() {
		return prioridadeTarefa;
	}

	public void setPrioridadeTarefa(TaskPriority prioridadeTarefa) {
		this.prioridadeTarefa = prioridadeTarefa;
	}

}
