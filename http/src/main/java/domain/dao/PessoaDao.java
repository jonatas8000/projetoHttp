package domain.dao;

import java.util.ArrayList;
import java.util.List;

import domain.model.Pessoa;

public class PessoaDao {

	private List<Pessoa> pessoaList = new ArrayList<>();
	
	public PessoaDao() {
		
		pessoaList.add(new Pessoa(1L, "Jose"));
	}
	
	
	public Pessoa buscarPorId(Long id) {
		return pessoaList.stream().filter(e->e.getId().equals(id)).findFirst().get();
	}
	
	public List<Pessoa> buscarPessoas(){
		return pessoaList;
	}
}
