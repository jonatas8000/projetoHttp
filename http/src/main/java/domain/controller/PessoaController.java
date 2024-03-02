package domain.controller;

import java.util.List;

import domain.dto.PessoaDTO;
import domain.exception.PessoaNaoEncontradaException;
import domain.service.PessoaService;
import domain.serviceImpl.PessoaServiceImpl;

public class PessoaController {
	
	
	private PessoaService pessoaService;
	
	public PessoaController() {
		 pessoaService = new PessoaServiceImpl();
	}
	
	public void salvarPessoa(PessoaDTO pessoaDTO) {
		pessoaService.salvar(pessoaDTO);
	}
	
	public void atualizarPessoa(PessoaDTO pessoaDTO) {
		pessoaService.atualizar(pessoaDTO);
	}
	
	public List<PessoaDTO> buscarPessoas(){
		return pessoaService.buscarPessoas();
	}

	public void excluirPessoa(Long id) throws PessoaNaoEncontradaException {
		pessoaService.excluir(id);
	}
}
