package com.sistema.atendimento.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class AtendimentoChamadoInstalacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_chamadoinstalacao", nullable = false)
	private ChamadoInstalacao chamadoInstalacao;
	
	@Transient
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "atendimentoChamadoInstalacao")
	private Set<EquipamentoUtilizadoAtendimentoChamadoInstalacao> equipamentoUtilizado = new HashSet<>();
	
	@Column(length= 1)
	private String instalacaoEncerrada; 
	
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


	public final Set<EquipamentoUtilizadoAtendimentoChamadoInstalacao> getEquipamentoUtilizado() {
		return equipamentoUtilizado;
	}


	public final void setEquipamentoUtilizado(Set<EquipamentoUtilizadoAtendimentoChamadoInstalacao> equipamentoUtilizado) {
		this.equipamentoUtilizado = equipamentoUtilizado;
	}


	public final String getInstalacaoEncerrada() {
		return instalacaoEncerrada;
	}


	public final void setInstalacaoEncerrada(String instalacaoEncerrada) {
		this.instalacaoEncerrada = instalacaoEncerrada;
	}
	
	
	

}
