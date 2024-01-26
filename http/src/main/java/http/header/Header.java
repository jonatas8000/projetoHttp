package http.header;

import java.util.List;

import http.StatusEnum;

public class Header {
	

	private List<String> requestHeader;
	private Metodo metodo;
	private String path;
	private StatusEnum status;
	
	
	public Header(StatusEnum status) {
		this.status=status;
	}
	
	public Header(List<String> requestHeader) {
		super();
		this.requestHeader = requestHeader;
	}
	
	

	public Metodo getMetodo() {
		return metodo;
	}



	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}
	

	public String getPath() {
		return path;
	}



	public String response() {
		return   "HTTP/1.1 "+status.getDescricao()+"\r\n" 
				 +"Date: Thu, 13 Jul 2017 02:02:45 GMT\r\n"
				 +"Last-Modified:Mon, 10 Jul 2017 21:30:06 GMT\r\n"
				+"Accept-Ranges:  none\r\n"
				 +"Connection: close\r\n"
				 +"Content-Type: application/json; charset=UTF-8\r\n"
				 +"Cookie: test=114&username=João\r\n\r\n";
		
				
	}
	
	public void carregarMetodo() {
		metodo= Metodo.valueOf(requestHeader.get(0).split(" ")[0]);
	}
	
	public void carregarPath() {
		path= requestHeader.get(0).split(" ")[1].substring(1);
	}
	
	public static boolean isFimHeader( byte[] linhaBytes) {
		int tamanho=linhaBytes.length;
		boolean isFimLinha=false;
		
		int indice=0;
		while(indice<tamanho) {
			if(isFimHeader(linhaBytes, indice)) {
				  isFimLinha=true;
				  break;
			}
			
			indice++;
		}
		
		return isFimLinha;
	}
	
	public static boolean isFimHeader(byte[] linhaBytes,int indice) {
		return linhaBytes[indice]==13&&linhaBytes[indice+2]==13
				&&linhaBytes[indice+1]==10&&linhaBytes[indice+3]==10;
	}
	


}