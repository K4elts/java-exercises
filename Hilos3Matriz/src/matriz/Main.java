package matriz;

public class Main {

	public static void main(String[] args) {
		
		final int FILAS = 20;
		final int COLUMNAS = 100;
		int [][]matriz = new int[FILAS][COLUMNAS];
		
		Runtime r = Runtime.getRuntime();
		int numCore = r.availableProcessors();
		
		int rango = FILAS/numCore;
		int inicio = 0;
		int fin = rango;
		
		//ThMatriz []th = new ThMatriz[numCore];
		Thread []th = new Thread[numCore];
		for (int i = 0; i < th.length; i++) {
			th[i] = new Thread(new ThMatriz(inicio,fin,(i+1),matriz));
			//th[i] = new ThMatriz(inicio, fin, (i+1), matriz);
			th[i].start();
			inicio = inicio + rango;
			fin = fin + rango;
			if (i == th.length-2) {
				fin = FILAS;
			}
		}

		for (int i = 0; i < th.length; i++) {
			try {
				th[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}

	}

}
