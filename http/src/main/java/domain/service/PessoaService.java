package domain.service;

import java.util.List;

import domain.dto.PessoaDTO;

public interface PessoaService {

	public PessoaDTO buscarPorId(Long id);
	
	public List<PessoaDTO> buscarPessoas();
	
	public void salvar(PessoaDTO pessoaDTO);
		
}
