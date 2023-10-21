package util;

public class ArrayByte {
	
	private byte caracteres [];
	private int contador;
	
	public ArrayByte() {
		 caracteres = new byte[50];
		 contador=0;
	}
	
	public void addByte(byte valor) {
		if(contador+1==caracteres.length)
			this.aumentarArray();
		
		caracteres[contador]=valor;
		contador++;
		
		
		
	}
	
	
	 public byte[] getCaracteres() {
		return caracteres;
	}

	private void aumentarArray(){
	       byte novoArray []  = new byte[caracteres.length+50]; 
	       
	            for(int i =0; i < caracteres.length; i++){
	                novoArray[i] = caracteres[i];
	            }
	            caracteres = novoArray;
	                       
	        }  

	
}
