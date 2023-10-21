package util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import domain.dto.PessoaDTO;



public class ConvertToJson {
public static String execute(Object obj) {
		
		Class<?> c = obj.getClass();
		
		Field[] fields = c.getDeclaredFields();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("{");
		
		for (Field field : fields) {
			
		
				try {
					
					if(stringBuilder.length() > 1) {
						stringBuilder.append(", ");
					}
					
					field.setAccessible(true);
					
					Object fieldValue = field.get(obj);
					
					
					
					stringBuilder.append("\""+field.getName()+"\":" + (fieldValue != null ? "\""+fieldValue+"\"" : "\"\""));
					
				} catch (IllegalArgumentException | IllegalAccessException e) {
					
					e.printStackTrace();
				}
			}
		
		
		stringBuilder.append("}");
		
		return stringBuilder.toString();		
	}



  public static Object convertToObject(Object obj,String body) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
	  
	  Field[] fields = obj.getClass().getDeclaredFields();
	 
	  
		for (Field field : fields) {
			
			String nome = field.getName();
			
			int posicao= body.indexOf(nome);
			int inicioPosicaoValor=  body.indexOf(":",posicao);
			int fimPosicaoValor=body.indexOf(",", posicao);
			
			if(fimPosicaoValor!=-1) {
				setValor(inicioPosicaoValor, fimPosicaoValor, field, body,obj);
			}else {
				fimPosicaoValor=body.lastIndexOf("\r\n");
				setValor(inicioPosicaoValor, fimPosicaoValor, field, body,obj);
			}
			
			
		}
	  
	  
	  
	  return obj;
  }
  
  private static void setValor(int inicioPosicaoValor,int fimPosicaoValor,Field field,String body,Object obj) throws IllegalArgumentException, IllegalAccessException {
	  String tipo=field.getType().getTypeName();
	  field.setAccessible(true);
	  String valor;
	  valor=body.substring(inicioPosicaoValor+1, fimPosicaoValor).replaceAll("\"", "");
	  try {
	  Class<?> type=new PessoaDTO().getClass().getDeclaredField("id").getType();
	  
	  
		if(Long.TYPE==type)
			  System.out.println("sucesso!");
	} catch (NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  if(tipo.equalsIgnoreCase("java.lang.Long"))
		  field.set(obj, Long.parseLong(valor));
	  else
		field.set(obj, valor);
	  
  }
}
