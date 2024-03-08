package http;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import domain.controller.PessoaController;
import domain.dto.PessoaDTO;
import domain.exception.HttpException;
import http.header.Metodo;
import util.ConvertToJson;

public class RoteadorUrl {
	
	public PessoaController pessoaController;
	
	public RoteadorUrl() {
		pessoaController=new PessoaController();
	}
	
	
	public Response executarController(String url,Metodo metodo,String body) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		if(url.matches("pessoa/\\d")&&Metodo.GET.equals(metodo)) {
			int posicao= url.indexOf("/");
			String json;
			try {
				json=ConvertToJson.execute(pessoaController.buscarPorId(Long.parseLong(url.substring(posicao+1,url.length()))));
			} catch (HttpException e) {
				 
				return e.gerarErro();
			}
			return new Response(StatusEnum.OK, json);	
		
		}else if(url.equals("pessoa")&&Metodo.GET.equals(metodo)) {
			if(pessoaController.buscarPessoas() instanceof Collection) {
				String json="{\"pessoa\":[";
				for(Object o : pessoaController.buscarPessoas()) {
					json=json+ConvertToJson.execute(o)+",";
				}
				json=json.substring(0, json.length()-1);
				json=json+"]}";
				return new Response(StatusEnum.OK, json);
			}
				
		}else if(url.equals("pessoa")&&Metodo.POST.equals(metodo)) {
			pessoaController.salvarPessoa((PessoaDTO) ConvertToJson.convertToObject(new PessoaDTO(), body));
			return new Response(StatusEnum.CREATED, null);	
		}else if(url.equals("pessoa")&&Metodo.PUT.equals(metodo)) {
			pessoaController.atualizarPessoa((PessoaDTO) ConvertToJson.convertToObject(new PessoaDTO(), body));
			return new Response(StatusEnum.OK, null);	
		}else if (url.matches("pessoa/\\d")&&Metodo.DELETE.equals(metodo)) {
			int posicao= url.indexOf("/");
			try {
				pessoaController.excluirPessoa(Long.parseLong(url.substring(posicao+1,url.length())));
			} catch (HttpException e) {
				 
				return e.gerarErro();
			}
			return new Response(StatusEnum.OK, null);	
		}
		
		
		return null;
	}
	
	
	
	
	
	

}
