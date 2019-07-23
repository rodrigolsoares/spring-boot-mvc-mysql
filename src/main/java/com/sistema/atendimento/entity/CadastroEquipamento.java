package com.sistema.atendimento.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CadastroEquipamento {

	@Id
	private Long id;
	private String nome;

	public CadastroEquipamento() {
	}
	
	public CadastroEquipamento(Long id) {
		this.id = id;
	}
	
	public CadastroEquipamento(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
