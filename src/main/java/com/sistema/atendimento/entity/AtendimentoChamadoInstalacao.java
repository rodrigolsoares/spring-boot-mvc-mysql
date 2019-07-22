package com.sistema.atendimento.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AtendimentoChamadoInstalacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_chamadoinstalacao", nullable = false)
	private ChamadoInstalacao chamadoInstalacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataAtendimento;

	
	public AtendimentoChamadoInstalacao() {
	}


	public final Long getId() {
		return id;
	}


	public final void setId(Long id) {
		this.id = id;
	}


	public final ChamadoInstalacao getChamadoInstalacao() {
		return chamadoInstalacao;
	}


	public final void setChamadoInstalacao(ChamadoInstalacao chamadoInstalacao) {
		this.chamadoInstalacao = chamadoInstalacao;
	}


	public final Date getDataAtendimento() {
		return dataAtendimento;
	}


	public final void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	

}
