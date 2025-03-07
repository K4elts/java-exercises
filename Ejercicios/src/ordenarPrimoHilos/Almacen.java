package ordenarPrimoHilos;

import java.util.*;

public class Almacen {
	
	TreeSet<Integer> n;
	
	public Almacen() {
		n = new TreeSet<Integer>();
		
	}
	
	public synchronized void insertaNumeroPrimo(int numPrimo) {
		n.add(numPrimo);
	}
	
	public Iterator getIterador() {
		return n.iterator();
	}
}
