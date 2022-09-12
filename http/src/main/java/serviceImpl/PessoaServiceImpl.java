package serviceImpl;

import DTO.PessoaDTO;
import dao.PessoaDao;
import mapper.PessoaMapper;
import service.PessoaService;

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

}
