package application;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import http.Request;

public class Servidor {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(80);
			
			
			while(true) {
				
				
				Socket socket= server.accept();
				
			    new Thread(new Request(socket),"request").start();
					
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
