package application;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import http.header.Header;
import http.request.Request;

public class Servidor {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(80);
			while(true) {
				
				
				Socket socket= server.accept();
				

				
			//	InputStream dados= socket.getInputStream();
				
			//	BufferedReader reader = new BufferedReader(new InputStreamReader(dados));
				
			   Thread teste= new Thread(new Request(socket),"request");
			   
			   
			   
			   teste.start();
			    
			   			    
			    

		/*	    PrintWriter printWriter= new PrintWriter(socket.getOutputStream());

			    
			    Header header = new Header();
			    
			    String resposta=header.response();
			    
			    
			    printWriter.print(resposta);
			    
			    printWriter.close(); */
			    
			    
						
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
