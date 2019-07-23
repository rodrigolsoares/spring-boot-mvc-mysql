package com.sistema.atendimento.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ChamadoInstalacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numero;
	
	@Transient
	private String chamadoEncerrado;

	public ChamadoInstalacao() {
	}

	public ChamadoInstalacao(String numero) {
		this.numero = numero;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getNumero() {
		return numero;
	}

	public final void setNumero(String numero) {
		this.numero = numero;
	}

	public final String getChamadoEncerrado() {
		return chamadoEncerrado;
	}

	public final void setChamadoEncerrado(String chamadoEncerrado) {
		this.chamadoEncerrado = chamadoEncerrado;
	}
	
	

}
