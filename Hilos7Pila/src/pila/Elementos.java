package pila;

public class Elementos {
	
	int []pila;
	int cima;
	
	boolean estavacio = true;
	
	public Elementos(int tope) {
		pila = new int[tope];
		cima = 0;
	}

	public synchronized Boolean ponerElemento(int num) {
		if (cima == pila.length) {
			System.out.println("La pila esta llena");
			return false;
		}
		if (num<0) {
			System.out.println("No se admiten negativos");
		}
		for (int i = 0; i < cima; i++) {
			if (pila[i]==num) {
				System.out.println("El numero ya está introducido");
				return false;
			}
		}
		pila[cima] = num;
		cima++;
		System.out.println("Se ha introducido el numero "+num);
		return true;
	}

	public synchronized int sacarElemento() {
		
		if (cima == 0) {
			System.out.println("La pila esta vacia");
			return -1;
		}
		cima--;
		System.out.println("Se ha sacado el numero");
		return pila[cima];
	}
	
}
