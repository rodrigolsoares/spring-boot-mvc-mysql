package com.sistema.atendimento.repository;

import org.springframework.data.repository.CrudRepository;

import com.sistema.atendimento.entity.ChamadoInstalacao;

public interface ChamadoInstalacaoRepository  extends CrudRepository<ChamadoInstalacao, Long>{
	
	ChamadoInstalacao findByNumero(String numero);
	
}
