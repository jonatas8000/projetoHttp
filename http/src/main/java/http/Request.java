package http;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import http.header.Header;
import http.header.HeaderFactory;

public class Request implements Runnable {

	private Header header;

	private Socket socket;
	
	private RoteadorUrl roteadorUrl;

	public Request(Socket socket)  {
		this.socket=socket;	
		this.roteadorUrl=new RoteadorUrl();

	}


	@Override
	public void run() {
		    List<String> linhasRequest=this.carregarLinhasRequest();
		    String body=null;
		    
		    if(linhasRequest!=null&&!linhasRequest.isEmpty()){
			this.carregarHeader(linhasRequest);
		     body=roteadorUrl.executarController(header.getPath(), header.getMetodo());

		    }
		    
		    
			this.response(body);
		    

	}
	
	private List<String> carregarLinhasRequest()  {
   
	List<String> linhasRequest = new ArrayList<>();	
	byte caracteres [] = new byte[2048];
	
	try {	
		
		  InputStream entrada = socket.getInputStream();
		  
		  
		
		 int indice=0;
		while(true) {
			
			 caracteres[indice]=(byte) entrada.read();
			
			 if(caracteres[0]==-1)
				break;
			 
			if(Header.isFimHeader(caracteres))
				break;
			
			indice++;
			
		}
		}catch(NoSuchElementException | IOException e) {
			return linhasRequest;
		}
	
	 if(caracteres[0]!=-1)
	linhasRequest.addAll(Arrays.asList(new String(caracteres).split("\r\n")));
	 
	 return linhasRequest;
	}

	private void carregarHeader(List<String> linhasRequest) {
	   header=  HeaderFactory.criarHeader(linhasRequest);
	
	}

	private void response(String body) {
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(socket.getOutputStream());
			Header header = new Header(new ArrayList<>());

			String resposta = header.response();
			
			if(body!=null)
				resposta=resposta+body;

			printWriter.print(resposta);

			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
