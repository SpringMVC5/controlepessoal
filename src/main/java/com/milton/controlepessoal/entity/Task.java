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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoTarefa == null) ? 0 : descricaoTarefa.hashCode());
		result = prime * result + ((dthrInclusao == null) ? 0 : dthrInclusao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((prioridadeTarefa == null) ? 0 : prioridadeTarefa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (descricaoTarefa == null) {
			if (other.descricaoTarefa != null)
				return false;
		} else if (!descricaoTarefa.equals(other.descricaoTarefa))
			return false;
		if (dthrInclusao == null) {
			if (other.dthrInclusao != null)
				return false;
		} else if (!dthrInclusao.equals(other.dthrInclusao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (prioridadeTarefa != other.prioridadeTarefa)
			return false;
		return true;
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
