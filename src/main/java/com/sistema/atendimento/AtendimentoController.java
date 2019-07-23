package com.sistema.atendimento;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.atendimento.entity.AtendimentoChamadoInstalacao;
import com.sistema.atendimento.entity.CadastroEquipamento;
import com.sistema.atendimento.entity.ChamadoInstalacao;
import com.sistema.atendimento.entity.EquipamentoUtilizadoAtendimentoChamadoInstalacao;
import com.sistema.atendimento.entity.MotivoAvariaEquipamento;
import com.sistema.atendimento.repository.AtendimentoChamadoInstalacaoRepository;
import com.sistema.atendimento.repository.CadastroEquipamentoRepository;
import com.sistema.atendimento.repository.ChamadoInstalacaoRepository;
import com.sistema.atendimento.repository.EquipamentoUtilizadoAtendimentoChamadoInstalacaoRepository;
import com.sistema.atendimento.repository.MotivoAvariaEquipamentoRepository;
import com.sistema.atendimento.repository.ResponsavelAvariaRepository;
import com.sistema.atendimento.vo.AtendimentoVO;

@Controller
public class AtendimentoController {
	
	@Autowired
    private CadastroEquipamentoRepository repositoryEquipamento;
    
    @Autowired
    private ResponsavelAvariaRepository responsavelOrigemAvaria;
    
    @Autowired
    private AtendimentoChamadoInstalacaoRepository atendimentoChamadoInstalacao;
    
    @Autowired
    private ChamadoInstalacaoRepository chamadoInstalacaoRepository;
    
    @Autowired
    private EquipamentoUtilizadoAtendimentoChamadoInstalacaoRepository equipamentoUtilizadoRepository;
    
    @Autowired
    private MotivoAvariaEquipamentoRepository motivoAvariaEquipamentoRepository;

	@RequestMapping("/")
	public ModelAndView inicio() {
		
		ModelAndView model = new ModelAndView("atendimento");
		model.addObject("equipamentos", repositoryEquipamento.findAll());
		model.addObject("responsaveisAvarias", responsavelOrigemAvaria.findAll());
		return model;
	}
	
	@RequestMapping("/tratarChamado/{numeroInstalacao}")
	public @ResponseBody ChamadoInstalacao tratarChamado(@PathVariable String numeroInstalacao) {
		ChamadoInstalacao chamadoInstalacao = chamadoInstalacaoRepository.findByNumero(numeroInstalacao);
		
		if(chamadoInstalacao != null){
			
			List<AtendimentoChamadoInstalacao> atendimentos = atendimentoChamadoInstalacao.findByChamadoInstalacao(chamadoInstalacao);
			
			for(AtendimentoChamadoInstalacao atendimento : atendimentos){
				if("S".equals(atendimento.getInstalacaoEncerrada())){
					chamadoInstalacao.setChamadoEncerrado("S");
					break;
				}
			}
		
		}
		
		return chamadoInstalacao; 
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/reportarAtendimento")
	public @ResponseBody AtendimentoVO reportarAtendimento(@RequestBody AtendimentoVO atendimentoVO) {
		
		AtendimentoChamadoInstalacao entity = this.parseVoParaEntity(atendimentoVO);
		
		atendimentoChamadoInstalacao.save(entity);
		
		for(EquipamentoUtilizadoAtendimentoChamadoInstalacao equipamento : entity.getEquipamentoUtilizado()){
			
			if(equipamento.getMotivoAvariaEquipamento() != null){
				motivoAvariaEquipamentoRepository.save(equipamento.getMotivoAvariaEquipamento());
			}
			
			equipamentoUtilizadoRepository.save(equipamento);
		}
		
		
		return atendimentoVO;
	}
	
	@RequestMapping("/reportarAtendimentoMock")
	public String reportarAtendimento() {
		
		AtendimentoVO atendimento= new AtendimentoVO();
		
		atendimento.setIdInstalacao("1");
		atendimento.setIdModem("2");
		atendimento.setIdAvarias("3");
		atendimento.setNumeroInstalacao("12345");
		atendimento.setInstalacaoEncerrada("N");
		atendimento.setTextoMotivoNaoInstalacao("TESTE REFACTOR");
		
		this.reportarAtendimento(atendimento);
		
		return "testeReportAtendimento";
	}
	
	private  AtendimentoChamadoInstalacao parseVoParaEntity(AtendimentoVO atendimento){
		
		AtendimentoChamadoInstalacao entity = new AtendimentoChamadoInstalacao();
		
		ChamadoInstalacao chamadoInstalacao = new ChamadoInstalacao();
		chamadoInstalacao.setId(this.parseStringParaLong(atendimento.getIdInstalacao()));
		chamadoInstalacao.setNumero(atendimento.getNumeroInstalacao());
		
		entity.setChamadoInstalacao(chamadoInstalacao);
		entity.setDataAtendimento(new Date());
		entity.setInstalacaoEncerrada(atendimento.getInstalacaoEncerrada());
		
		EquipamentoUtilizadoAtendimentoChamadoInstalacao equipamento = new EquipamentoUtilizadoAtendimentoChamadoInstalacao();
		
		equipamento.setCadastroEquipamento(new CadastroEquipamento(this.parseStringParaLong(atendimento.getIdModem())));
		equipamento.setAtendimentoChamadoInstalacao(entity);
		
		if(atendimento.getIdAvarias() != null && !atendimento.getIdAvarias().equals("")){
			equipamento.setMotivoAvariaEquipamento(new MotivoAvariaEquipamento(atendimento.getTextoMotivoNaoInstalacao(), this.parseStringParaLong(atendimento.getIdAvarias())));
		}
		
		entity.getEquipamentoUtilizado().add(equipamento);
		
		return entity;
	}
	
	private Long parseStringParaLong(String valor){
		
		if(valor == null || "".equals(valor)){
			return null;
		}
		
		return Long.parseLong(valor);
	}

}