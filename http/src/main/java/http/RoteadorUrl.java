package http;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import domain.controller.PessoaController;
import domain.dto.PessoaDTO;
import http.header.Metodo;
import util.ConvertToJson;

public class RoteadorUrl {
	
	public PessoaController pessoaController;
	
	public RoteadorUrl() {
		pessoaController=new PessoaController();
	}
	
	
	public Response executarController(String url,Metodo metodo,String body) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		if(url.equals("pessoa")&&Metodo.GET.equals(metodo)) {
			
			
			if(pessoaController.buscarPessoas() instanceof Collection) {
				String json="{\"pessoa\":[";
				for(Object o : pessoaController.buscarPessoas()) {
					json=json+ConvertToJson.execute(o);
				}
				json=json+"]}";
				return new Response(StatusEnum.OK, json);
			}
			
			return null;
				
		}
	
		else if(url.equals("pessoa")&&Metodo.POST.equals(metodo)) {
			pessoaController.salvarPessoa((PessoaDTO) ConvertToJson.convertToObject(new PessoaDTO(), body));
		}
		return new Response(StatusEnum.CREATED, null);	
		
	}
	
	
	
	
	
	

}
