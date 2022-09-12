package mapper;

import DTO.PessoaDTO;
import model.Pessoa;

public class PessoaMapper implements Mapper<Pessoa, PessoaDTO>{

	@Override
	public Pessoa toEntity(PessoaDTO dto) {
		return new Pessoa(dto.getId(),dto.getNome());
	}

	@Override
	public PessoaDTO toDTO(Pessoa entity) {
		return new PessoaDTO(entity.getId(), entity.getNome());
	}

}
