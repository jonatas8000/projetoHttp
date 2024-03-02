package http;

public enum StatusEnum {
	OK("200 OK"),
	CREATED("201 Created"),
	NOT_FOUND("404 Not Found");
	
	private String descricao;
	
	 StatusEnum(String descricao) {
		this.descricao=descricao;
	}

	 public String getDescricao() {
		 return descricao;
	 }
}
