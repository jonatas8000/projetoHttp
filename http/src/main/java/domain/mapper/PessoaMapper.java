package domain.mapper;

import java.util.ArrayList;
import java.util.List;

import domain.dto.PessoaDTO;
import domain.model.Pessoa;

public class PessoaMapper implements Mapper<Pessoa, PessoaDTO>{

	@Override
	public Pessoa toEntity(PessoaDTO dto) {
		return new Pessoa(dto.getId(),dto.getNome());
	}

	@Override
	public PessoaDTO toDTO(Pessoa entity) {
		return new PessoaDTO(entity.getId(), entity.getNome());
	}

	@Override
	public List<Pessoa> toEntity(List<PessoaDTO> listDTO) {
		List<Pessoa> listPessoa= new ArrayList<>();
		
		for(PessoaDTO pessoaDTO : listDTO)
			listPessoa.add(this.toEntity(pessoaDTO));
			
		return listPessoa;
	}

	@Override
	public List<PessoaDTO> toDTO(List<Pessoa> listEntity) {
	List<PessoaDTO> listPessoaDTO= new ArrayList<>();
		
		for(Pessoa pessoa : listEntity)
			listPessoaDTO.add(this.toDTO(pessoa));
			
		return listPessoaDTO;
	}

}
