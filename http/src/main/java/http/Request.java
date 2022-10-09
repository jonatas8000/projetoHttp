package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import http.header.Header;
import http.header.HeaderFactory;
import http.header.Metodo;

public class Request implements Runnable {

	private List<String> linhasRequest = new ArrayList<>();

	private Header header;

	private Socket socket;

	public Request(Socket socket) throws IOException {
		this.socket=socket;
		Scanner scanner = new Scanner (socket.getInputStream());
		
		String linha;
		int count=1;
		while(count!=16&&(linha = scanner.nextLine())!=null) {
			System.out.println(count);
			linhasRequest.add(linha);
			count++;
		}
		
		

	}

	public List<String> getLinhasRequest() {
		return linhasRequest;
	}

	@Override
	public void run() {
		
			this.carregarHeader();
			this.response();


	}

	private void carregarHeader() {
	   header=  HeaderFactory.criarHeader(linhasRequest);
	
	}

	private void response() {
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(socket.getOutputStream());
			Header header = new Header(new ArrayList());

			String resposta = header.response();

			printWriter.print(resposta);

			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
