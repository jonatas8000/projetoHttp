package http;

import java.util.Collection;

import domain.controller.PessoaController;
import http.header.Metodo;
import util.ConvertToJson;

public class RoteadorUrl {
	
	public PessoaController pessoaController;
	
	public RoteadorUrl() {
		pessoaController=new PessoaController();
	}
	
	
	public String executarController(String url,Metodo metodo) {
		if(url.equals("pessoa")&&Metodo.GET.equals(metodo)) {
			
			
			if(pessoaController.buscarPessoas() instanceof Collection) {
				String json="{\"pessoa\":[";
				for(Object o : pessoaController.buscarPessoas()) {
					json=json+ConvertToJson.execute(o);
				}
				json=json+"]}";
				return json;
			}
			
			return null;
				
		}
	
		else
		return null;	
		
	}
	
	
	
	
	
	

}
