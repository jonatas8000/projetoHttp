package util;

import java.lang.reflect.Field;

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
}
