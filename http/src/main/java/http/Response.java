package http;

import http.header.Header;

public class Response {
  
	private Header header;
	private String body;
	
	public Response (StatusEnum status, String body) {
		this.header = new Header(status);
		this.body=body;
	}

	@Override
	public String toString() {
		if(body!=null)
			return header.response()+body;
		
		return header.response();
	}
	
	
	
}
