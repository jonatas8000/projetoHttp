package domain.service;

import java.util.List;

import domain.dto.PessoaDTO;
import domain.exception.PessoaNaoEncontradaException;

public interface PessoaService {

	public PessoaDTO buscarPorId(Long id) throws PessoaNaoEncontradaException;
	
	public List<PessoaDTO> buscarPessoas();
	
	public void salvar(PessoaDTO pessoaDTO);
	
	public void atualizar(PessoaDTO pessoaDTO);
	
	public void excluir (Long id) throws PessoaNaoEncontradaException;
		
}
