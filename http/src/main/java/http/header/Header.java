package http.header;

public class Header {
	

	public String response() {
		return   "HTTP/1.1 200 OK\r\n" 
				 +"Date: Thu, 13 Jul 2017 02:02:45 GMT\r\n"
				 +"Last-Modified:Mon, 10 Jul 2017 21:30:06 GMT\r\n"
				+"Accept-Ranges:  none\r\n"
				 +"Connection: close\r\n"
				 +"Content-Type: text/html; charset=UTF-8\r\n"
				 +"Cookie: test=114&username=João\r\n\r\n"
				+"<html><head></head><body><header>"
				+"<title>http://info.cern.ch</title>"
				+"</header>"
				+"<h1>Olá, mundo</h1>"
				+"</body></html>";
				
	}
	

}