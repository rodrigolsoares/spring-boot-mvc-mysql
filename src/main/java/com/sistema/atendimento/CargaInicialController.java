package com.sistema.atendimento;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistema.atendimento.entity.CadastroEquipamento;
import com.sistema.atendimento.entity.ChamadoInstalacao;
import com.sistema.atendimento.entity.ResponsavelAvaria;
import com.sistema.atendimento.repository.CadastroEquipamentoRepository;
import com.sistema.atendimento.repository.ChamadoInstalacaoRepository;
import com.sistema.atendimento.repository.ResponsavelAvariaRepository;

@Controller
public class CargaInicialController {


	private static final Logger LOG = LoggerFactory.getLogger(CargaInicialController.class);

    @Autowired
    private CadastroEquipamentoRepository cadastroEquipamentoRepository;
    
    @Autowired
    private ResponsavelAvariaRepository responsavelOrigemAvaria;
    
    @Autowired
    private ChamadoInstalacaoRepository chamadoInstalacao;

	@RequestMapping("/cargaInicial")
	public String welcome(Map<String, Object> model) {
		
		LOG.info("Carga Equipamento");
		cadastroEquipamentoRepository.save(new CadastroEquipamento(1l, "Cisco"));
		cadastroEquipamentoRepository.save(new CadastroEquipamento(2l, "Alcatel"));
		cadastroEquipamentoRepository.save(new CadastroEquipamento(3l, "Tp Link"));
		
		LOG.info("Carga responsavel origem avaria");
		responsavelOrigemAvaria.save(new ResponsavelAvaria(1l, "Custo gerado pela transportadora"));
		responsavelOrigemAvaria.save(new ResponsavelAvaria(2l, "Custo gerado pela empresa responsável pela instalação"));
		responsavelOrigemAvaria.save(new ResponsavelAvaria(3l, "Custo gerado pelo cliente"));
        
		LOG.info("Número Chamado");
		chamadoInstalacao.save(new ChamadoInstalacao("12345"));
		chamadoInstalacao.save(new ChamadoInstalacao("12346"));
		chamadoInstalacao.save(new ChamadoInstalacao("12347"));
		
		return "cargaInicial";
	}

}