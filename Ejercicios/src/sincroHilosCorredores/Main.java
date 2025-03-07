package sincroHilosCorredores;

public class Main {
	
	
	public static void main(String[] args) {
		final int N = 8;
		Almacen al = new Almacen(N);
		
		ThCorredor []corredor = new ThCorredor[N];
		
		for (int i=0;i<N;i++) {
			corredor[i] = new ThCorredor((i+1),al);
			corredor[i].start();
		}
		//System.out.println("Hilos lanzados, esperando que terminen");
		
		for (int i=0;i<N;i++) {
			try {
				corredor[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int[]dorsales = al.getDorsales();
		for (int j = 0; j < dorsales.length; j++) {
			System.out.println("Corredor con dorsal: "+dorsales[j]+" posicion "+(j+1));
		}
		
		
		
	}//main

}//clase
