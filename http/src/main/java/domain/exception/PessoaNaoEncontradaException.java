package domain.exception;

import java.time.LocalDateTime;

import domain.dto.ErroDTO;
import http.Response;
import http.StatusEnum;
import util.ConvertToJson;

public class PessoaNaoEncontradaException extends HttpException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PessoaNaoEncontradaException(String mensagem) {
		super(mensagem);		
	}

	@Override
	public Response gerarErro() {
		ErroDTO erro = new ErroDTO();
		erro.setMensagem(mensagem);
		erro.setCodigo(404);
		erro.setDataHoraErro(LocalDateTime.now());
		return new Response(StatusEnum.NOT_FOUND, ConvertToJson.execute(erro));
	}

}
