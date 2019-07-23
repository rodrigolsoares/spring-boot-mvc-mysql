package com.sistema.atendimento.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResponsavelAvaria {
	
	@Id
	private Long id;
	private String nomeGrupoResponsavel;
	
	public ResponsavelAvaria() {
	}
	
	public ResponsavelAvaria(Long id) {
		this.id = id;
	}
	
	public ResponsavelAvaria(Long id, String nomeGrupoResponsavel) {
		this.id = id;
		this.nomeGrupoResponsavel = nomeGrupoResponsavel;
	}
	
	
	public final Long getId() {
		return id;
	}
	
	public final void setId(Long id) {
		this.id = id;
	}
	
	public final String getNomeGrupoResponsavel() {
		return nomeGrupoResponsavel;
	}
	
	public final void setNomeGrupoResponsavel(String nomeGrupoResponsavel) {
		this.nomeGrupoResponsavel = nomeGrupoResponsavel;
	}
	
	
}
