package domain.serviceImpl;

import java.util.List;

import domain.dao.PessoaDao;
import domain.dto.PessoaDTO;
import domain.exception.PessoaNaoEncontradaException;
import domain.mapper.PessoaMapper;
import domain.service.PessoaService;

public class PessoaServiceImpl implements PessoaService {

	private PessoaDao pessoaDao;
	
	private PessoaMapper pessoaMapper;
	
	public PessoaServiceImpl () {
		this.pessoaDao= PessoaDao.getInstance();
		this.pessoaMapper=new PessoaMapper();
	}
	
	@Override
	public PessoaDTO buscarPorId(Long id) throws PessoaNaoEncontradaException {
		return pessoaMapper.toDTO(pessoaDao.buscarPorId(id).orElseThrow(()-> new PessoaNaoEncontradaException("Pessoa não encontrada")));
	}

	@Override
	public List<PessoaDTO> buscarPessoas() {
		return  pessoaMapper.toDTO(pessoaDao.buscarPessoas());
	}

	@Override
	public void salvar(PessoaDTO pessoaDTO) {
		pessoaDao.salvar(pessoaMapper.toEntity(pessoaDTO));
	}

	@Override
	public void atualizar(PessoaDTO pessoaDTO) {
		pessoaDao.atualizar(pessoaMapper.toEntity(pessoaDTO));	
	}

	@Override
	public void excluir(Long id) throws PessoaNaoEncontradaException {
		this.buscarPorId(id);
		pessoaDao.excluir(id);
	}

}
