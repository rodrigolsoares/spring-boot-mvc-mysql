package com.sistema.atendimento.vo;

public class AtendimentoVO {
	
	private String idInstalacao;
	private String numeroInstalacao;
	private String idModem;
	private String instalacaoEncerrada;
	private String idAvarias;
	private String textoMotivoNaoInstalacao;
	
	
	public final String getIdInstalacao() {
		return idInstalacao;
	}
	
	public final String getNumeroInstalacao() {
		return numeroInstalacao;
	}

	public final void setNumeroInstalacao(String numeroInstalacao) {
		this.numeroInstalacao = numeroInstalacao;
	}

	public final void setIdInstalacao(String idInstalacao) {
		this.idInstalacao = idInstalacao;
	}
	
	public final String getIdModem() {
		return idModem;
	}
	
	public final void setIdModem(String idModem) {
		this.idModem = idModem;
	}
	
	public final String getInstalacaoEncerrada() {
		return instalacaoEncerrada;
	}
	
	public final void setInstalacaoEncerrada(String instalacaoEncerrada) {
		this.instalacaoEncerrada = instalacaoEncerrada;
	}
	
	public final String getIdAvarias() {
		return idAvarias;
	}

	public final void setIdAvarias(String idAvarias) {
		this.idAvarias = idAvarias;
	}

	public final String getTextoMotivoNaoInstalacao() {
		return textoMotivoNaoInstalacao;
	}
	
	public final void setTextoMotivoNaoInstalacao(String textoMotivoNaoInstalacao) {
		this.textoMotivoNaoInstalacao = textoMotivoNaoInstalacao;
	}
	
	

}
