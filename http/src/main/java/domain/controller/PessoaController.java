package domain.controller;

import java.util.List;

import domain.dto.PessoaDTO;
import domain.service.PessoaService;
import domain.serviceImpl.PessoaServiceImpl;

public class PessoaController {
	
	
	private PessoaService pessoaService;
	
	public PessoaController() {
		 pessoaService = new PessoaServiceImpl();
	}
	
	public void salvarPessoa(PessoaDTO pessoaDTO) {
		
	}
	
	public List<PessoaDTO> buscarPessoas(){
		return pessoaService.buscarPessoas();
	}

}
