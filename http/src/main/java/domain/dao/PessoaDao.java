package domain.dao;

import java.util.ArrayList;
import java.util.List;

import domain.model.Pessoa;

public class PessoaDao {
	private static PessoaDao instance;

	private List<Pessoa> pessoaList = new ArrayList<>();
	
	private PessoaDao() {
		
		pessoaList.add(new Pessoa(1L, "Jose"));
	}
	
	
	public Pessoa buscarPorId(Long id) {
		return pessoaList.stream().filter(e->e.getId().equals(id)).findFirst().get();
	}
	
	public List<Pessoa> buscarPessoas(){
		return pessoaList;
	}
	
	public void salvar(Pessoa pessoa) {
		pessoaList.add(pessoa);
	}
	public void atualizar(Pessoa pessoaAtualizacao) {
		for(Pessoa pessoa : pessoaList) {
			if(pessoa.getId().equals(pessoaAtualizacao.getId()))
				pessoa.setNome(pessoaAtualizacao.getNome());
		}
	}
	
	public void excluir(Long id) {
		pessoaList.removeIf(e->e.getId().equals(id));
	}
	
	public static PessoaDao getInstance() {
	        if (instance == null) {
	            instance = new PessoaDao();
	        }
	        return instance;
	    }
}
