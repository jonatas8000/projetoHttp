package domain.dto;

import java.time.LocalDateTime;

public class ErroDTO {
    
	public int codigo;
	public String mensagem;
	public LocalDateTime dataHoraErro;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public LocalDateTime getDataHoraErro() {
		return dataHoraErro;
	}
	public void setDataHoraErro(LocalDateTime dataHoraErro) {
		this.dataHoraErro = dataHoraErro;
	}
	
	
}
