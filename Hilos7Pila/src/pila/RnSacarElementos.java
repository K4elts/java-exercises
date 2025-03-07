package pila;

public class RnSacarElementos implements Runnable{

	Elementos elementos;
	
	public RnSacarElementos(Elementos el) {
		this.elementos = el;
	}
	
	@Override
	public void run() {
		while(true) {
			elementos.sacarElemento();
		}

		
	}

}
