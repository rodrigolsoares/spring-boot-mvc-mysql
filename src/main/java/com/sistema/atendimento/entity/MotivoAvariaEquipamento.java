package com.sistema.atendimento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class MotivoAvariaEquipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_responsavelAvaria", nullable = false)
	private ResponsavelAvaria responsavelAvaria;
	
	@Column(length= 100)
	private String textoPadraoMotivoAvaria;
		
	public MotivoAvariaEquipamento() {
	}
	
	public MotivoAvariaEquipamento(String textoPadraoMotivoAvaria, Long idResponsavelAvaria) {
		this.textoPadraoMotivoAvaria = textoPadraoMotivoAvaria;
		this.responsavelAvaria = new ResponsavelAvaria(idResponsavelAvaria);
	}
	
	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final ResponsavelAvaria getResponsavelAvaria() {
		return responsavelAvaria;
	}

	public final void setResponsavelAvaria(ResponsavelAvaria responsavelAvaria) {
		this.responsavelAvaria = responsavelAvaria;
	}

	public final String getTextoPadraoMotivoAvaria() {
		return textoPadraoMotivoAvaria;
	}

	public final void setTextoPadraoMotivoAvaria(String textoPadraoMotivoAvaria) {
		this.textoPadraoMotivoAvaria = textoPadraoMotivoAvaria;
	}
	
	




}
