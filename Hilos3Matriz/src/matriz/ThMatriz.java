package matriz;

public class ThMatriz implements Runnable{
	
	int filaInicial,filaFinal,nHilo;
	
	int [][]matriz;
	
	
	public ThMatriz(int inicio,int filafinal,int id,int [][]mat) {
		this.filaInicial = inicio;
		this.filaFinal = filafinal;
		this.nHilo = id;
		this.matriz = mat;
	}

	@Override
	public void run() {
		
		for (int i = this.filaInicial; i < this.filaFinal; i++) {
			for (int columna = 0; columna < matriz[0].length; columna++) {
				this.matriz[i][columna] = this.nHilo;
			}
		}
		
	}
	
}
