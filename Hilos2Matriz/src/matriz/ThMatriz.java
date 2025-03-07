package matriz;

public class ThMatriz extends Thread{
	
	int idHilo;
	int almacen;
	int [][]m = new int [20][100];

	public ThMatriz(int hilo) {
		this.idHilo = hilo;
		//this.almacen = al;
		
	}
	public void Matriz() {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}
	
	@Override
	public void run() {
		Matriz();
	}
}
