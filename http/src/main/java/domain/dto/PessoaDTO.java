package domain.dto;

public class PessoaDTO  {

	public Long id;
	
	public String nome;
	
	

	public PessoaDTO() {
		super();
	}

	public PessoaDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
