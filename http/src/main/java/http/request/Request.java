package http.request;

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

public class Request implements Runnable {

	private List<String> linhasRequest = new ArrayList<>();

	private String metodoHttp;

	private Socket socket;

	public Request(Socket socket) throws IOException {
		this.socket=socket;
		Scanner scanner = new Scanner (socket.getInputStream());
		
		String linha;
		int count=1;
		while((linha = scanner.nextLine())!=null&&count<3) {
			linhasRequest.add(linha);
			count++;
		}

	}

	public List<String> getLinhasRequest() {
		return linhasRequest;
	}

	@Override
	public void run() {
		
			this.carregarMetodo();
			this.response();


	}

	private void carregarMetodo() {
		metodoHttp = linhasRequest.get(0);
		System.out.println(metodoHttp);

	}

	private void response() {
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(socket.getOutputStream());
			Header header = new Header();

			String resposta = header.response();

			printWriter.print(resposta);

			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
