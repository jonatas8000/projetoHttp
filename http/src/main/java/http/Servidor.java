package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import http.header.Header;

public class Servidor {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(80);
			while(true) {
				Socket socket= server.accept();
				
				PrintWriter printWriter= new PrintWriter(socket.getOutputStream());

				
		//		InputStream dados= socket.getInputStream();
				
		//		BufferedReader reader = new BufferedReader(new InputStreamReader(dados));
				
		//	    reader.lines().forEach(e->exibirLnha(e));
			    
			    Header header = new Header();
			    
			    String resposta=header.response();
			    
			    
			    printWriter.print(resposta);
			    
			    printWriter.close();
			    
			    
		
			    

				
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void exibirLnha(String linha) {
	
		System.out.println(linha);
	}

}
