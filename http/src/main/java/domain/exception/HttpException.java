package domain.exception;

import http.Response;

public abstract class HttpException extends Exception {
	
	public HttpException(String mensagem) {
		this.mensagem = mensagem;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String mensagem;
	
	
	
	public abstract Response gerarErro();

}
