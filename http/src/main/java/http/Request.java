package http;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import http.header.Header;
import http.header.HeaderFactory;
import util.ArrayByte;

public class Request implements Runnable {

	private Header header;

	private Socket socket;
	
	private RoteadorUrl roteadorUrl;
	
	private String bodyRequest;

	public Request(Socket socket)  {
		this.socket=socket;	
		this.roteadorUrl=new RoteadorUrl();

	}


	@Override
	public void run() {
		    this.carregarLinhasRequest();
		    Response response=null;
		    
		    if(header!=null){
		     try {
		    	 response=roteadorUrl.executarController(header.getPath(), header.getMetodo(),bodyRequest);
			} catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException
					| SecurityException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    }
		    
		    if(response!=null)
			this.response(response);
		    

	}
	
	private void carregarLinhasRequest()  {
   
	///byte caracteres [] = new byte[2048];
	ArrayByte arrayByte = new ArrayByte();	
	int inicioBody=0;
	
	
	try {	
		
		  InputStream entrada = socket.getInputStream();
		  
		  
		 int indice=0;
		while(true) {
			boolean fimHeader=false;
			
			arrayByte.addByte((byte)entrada.read());
			
			
			 if(arrayByte.getCaracteres()[0]==-1)
				break;
			 
			 fimHeader=Header.isFimHeader(arrayByte.getCaracteres());
			
			 if(fimHeader) {
				 this.carregarHeader(Arrays.asList(new String(arrayByte.getCaracteres()).split("\r\n")));
				 
				 if(inicioBody==0)
				 inicioBody=indice;
				 
				 if(header.getMetodo().toString().equalsIgnoreCase("GET")||arrayByte.getCaracteres()[indice]==125)
					 break;
				 
			 }
			 
			 	 
			indice++;
			
		}
		
		if(header!=null&&!header.getMetodo().toString().equalsIgnoreCase("GET"))
			this.carregarBody(arrayByte.getCaracteres(), inicioBody);
		
		 
		}catch(NoSuchElementException | IOException e) {
			
		}
	
	
	 
	 
	}

	private void carregarHeader(List<String> linhasRequest) {
	   header=  HeaderFactory.criarHeader(linhasRequest);
	
	}
	
	private void carregarBody(byte caractere[],int inicioBody) {
		int indice=inicioBody;
		int indiceBody=0;
		byte caracteresBody [] = new byte[2048];
		
		
		do {
			indice++;
			caracteresBody[indiceBody]=caractere[indice];
			indiceBody++;
		}while(caractere[indice]!=125);
		
		
		bodyRequest=new String(caracteresBody);
		int ultimoCaractere= bodyRequest.lastIndexOf("}");
		bodyRequest=bodyRequest.substring(0, ultimoCaractere+1);
		
	}
	

	private void response(Response response) {
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(socket.getOutputStream());
			

			printWriter.print(response.toString());

			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
