package http;

public enum StatusEnum {
	OK("200 OK"),
	CREATED("201 Created");
	
	private String descricao;
	
	 StatusEnum(String descricao) {
		this.descricao=descricao;
	}

	 public String getDescricao() {
		 return descricao;
	 }
}
