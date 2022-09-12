package dao;

import java.util.List;

import model.Pessoa;

public class PessoaDao {

	private List<Pessoa> pessoaList;
	
	public PessoaDao() {
		
		pessoaList.add(new Pessoa(1L, "Jose"));
	}
	
	
	public Pessoa buscarPorId(Long id) {
		return pessoaList.stream().filter(e->e.getId().equals(id)).findFirst().get();
	}
}
