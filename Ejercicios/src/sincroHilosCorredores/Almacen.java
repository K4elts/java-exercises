package sincroHilosCorredores;

public class Almacen {

	int []dorsales;
	int tope;
	
	public Almacen(int n) {
		dorsales = new int[n];
		tope = 0;
	}
	
	public synchronized void llegada(int dorsalcorredor) {
		
		dorsales[tope] = dorsalcorredor;
		tope++;
	}

	public int[] getDorsales() {
		return dorsales;
	}

	
	
	
}
