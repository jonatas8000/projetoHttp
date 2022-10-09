package http.header;

import java.util.List;

public class HeaderFactory {
	
	public static Header criarHeader(List<String> requestHeader) {
		Header header= new Header(requestHeader);
		header.carregarMetodo();
		
		return header;
		
	}

}
