package domain.serviceImpl;

import java.util.List;

import domain.dao.PessoaDao;
import domain.dto.PessoaDTO;
import domain.mapper.PessoaMapper;
import domain.service.PessoaService;

public class PessoaServiceImpl implements PessoaService {

	private PessoaDao pessoaDao;
	
	private PessoaMapper pessoaMapper;
	
	public PessoaServiceImpl () {
		this.pessoaDao=new PessoaDao();
		this.pessoaMapper=new PessoaMapper();
	}
	
	@Override
	public PessoaDTO buscarPorId(Long id) {
		return pessoaMapper.toDTO(pessoaDao.buscarPorId(id));
	}

	@Override
	public List<PessoaDTO> buscarPessoas() {
		return  pessoaMapper.toDTO(pessoaDao.buscarPessoas());
	}

}
