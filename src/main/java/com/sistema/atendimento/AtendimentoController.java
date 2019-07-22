package com.sistema.atendimento;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.atendimento.entity.AtendimentoChamadoInstalacao;
import com.sistema.atendimento.entity.ChamadoInstalacao;
import com.sistema.atendimento.repository.AtendimentoChamadoInstalacaoRepository;
import com.sistema.atendimento.repository.CadastroEquipamentoRepository;
import com.sistema.atendimento.repository.ChamadoInstalacaoRepository;
import com.sistema.atendimento.repository.ResponsavelAvariaRepository;

@Controller
public class AtendimentoController {

	// inject via application.properties
	//@Value("${welcome.message}")
	//private String message = "Hello World";
	
	@Autowired
    private CadastroEquipamentoRepository repositoryEquipamento;
    
    @Autowired
    private ResponsavelAvariaRepository responsavelOrigemAvaria;
    
    @Autowired
    private AtendimentoChamadoInstalacaoRepository atendimentoChamadoInstalacao;
    
    @Autowired
    private ChamadoInstalacaoRepository chamadoInstalacaoRepository;

	@RequestMapping("/")
	public ModelAndView inicio() {
		
		ModelAndView model = new ModelAndView("atendimento");
		model.addObject("equipamentos", repositoryEquipamento.findAll());
		model.addObject("responsaveisAvarias", responsavelOrigemAvaria.findAll());
		
		return model;
	}
	
	@RequestMapping("/tratarChamado/{numeroInstalacao}")
	public @ResponseBody List<AtendimentoChamadoInstalacao> tratarChamado(@PathVariable String numeroInstalacao) {
		ChamadoInstalacao chamadoInstalacao = chamadoInstalacaoRepository.findByNumero(numeroInstalacao);
		return atendimentoChamadoInstalacao.findByChamadoInstalacao(chamadoInstalacao);
	}
	
	@RequestMapping("/reportarAtendimento")
	public String reportarAtendimento(@RequestParam AtendimentoChamadoInstalacao atendimento) {
		atendimentoChamadoInstalacao.save(atendimento);
		return "sucesso";
	}
	
	@RequestMapping("/reportarAtendimentoMock")
	public String reportarAtendimento() {
		AtendimentoChamadoInstalacao atendimento = new AtendimentoChamadoInstalacao();
		atendimento.setDataAtendimento(new Date());
		ChamadoInstalacao chamadoInstalacao = new ChamadoInstalacao();
		chamadoInstalacao.setId(1l);
		chamadoInstalacao.setNumero("12345");
		atendimento.setChamadoInstalacao(chamadoInstalacao);
		atendimentoChamadoInstalacao.save(atendimento);
		return "sucesso";
	}

}