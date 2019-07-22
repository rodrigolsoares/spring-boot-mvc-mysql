package com.sistema.atendimento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sistema.atendimento.entity.AtendimentoChamadoInstalacao;
import com.sistema.atendimento.entity.ChamadoInstalacao;

public interface AtendimentoChamadoInstalacaoRepository  extends CrudRepository<AtendimentoChamadoInstalacao, Long>{
	
	List<AtendimentoChamadoInstalacao> findByChamadoInstalacao(ChamadoInstalacao chamadoInstalacao);
}
