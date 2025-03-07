package ordenarPrimoHilos;


public class Primos extends Thread{

	
		
	int inicio,fin,numHilo;
	Almacen al;


	public Primos(int ini,int fn,int nHilo,Almacen a) {
		this.inicio = ini;
		this.fin = fn;
		this.numHilo = nHilo;
		this.al = a;
	}

	public void escribePrimos() {
		for (int i = this.inicio; i < this.fin; i++) {
			if(esPrimo(i)) {
				//System.out.println("El hilo "+this.numHilo+" ha encontrado el numero: "+i);
				al.insertaNumeroPrimo(i);
			}
		}

	}
	public void run() {
		escribePrimos();
	}
		
	private boolean esPrimo(int n) {
		for(int i =2; i<n/2;i++) {
			if ((n%i)==0) {
				return false;
			}
		}
		return true;
	}


	}
	

	

	


