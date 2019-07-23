package com.sistema.atendimento.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class EquipamentoUtilizadoAtendimentoChamadoInstalacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_atendimentoChamadoInstalacao", nullable = false)
	private AtendimentoChamadoInstalacao atendimentoChamadoInstalacao;
	
	@ManyToOne
	@JoinColumn(name = "id_cadastroEquipamento", nullable = true)
	private CadastroEquipamento cadastroEquipamento;
	
	@OneToOne
	@JoinColumn(name = "id_motivoAvariaEquipamento", nullable = true)
	private MotivoAvariaEquipamento motivoAvariaEquipamento;
	
	
	
	public EquipamentoUtilizadoAtendimentoChamadoInstalacao() {
	}


	public final Long getId() {
		return id;
	}


	public final void setId(Long id) {
		this.id = id;
	}


	public final AtendimentoChamadoInstalacao getAtendimentoChamadoInstalacao() {
		return atendimentoChamadoInstalacao;
	}


	public final void setAtendimentoChamadoInstalacao(AtendimentoChamadoInstalacao atendimentoChamadoInstalacao) {
		this.atendimentoChamadoInstalacao = atendimentoChamadoInstalacao;
	}


	public final CadastroEquipamento getCadastroEquipamento() {
		return cadastroEquipamento;
	}


	public final void setCadastroEquipamento(CadastroEquipamento cadastroEquipamento) {
		this.cadastroEquipamento = cadastroEquipamento;
	}


	public final MotivoAvariaEquipamento getMotivoAvariaEquipamento() {
		return motivoAvariaEquipamento;
	}


	public final void setMotivoAvariaEquipamento(MotivoAvariaEquipamento motivoAvariaEquipamento) {
		this.motivoAvariaEquipamento = motivoAvariaEquipamento;
	}

	

}
