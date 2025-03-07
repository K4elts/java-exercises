package pila;

public class Main {

	public static void main(String[] args) {
		final int N = 6;
		
		Elementos elemento = new Elementos(N);
		
		new Thread(new RnSacarElementos(elemento)).start();
		new Thread(new RnPonerElementos(elemento)).start();
		
	}

}
