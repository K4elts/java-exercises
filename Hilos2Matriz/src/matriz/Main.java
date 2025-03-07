package matriz;

public class Main {

	public static void main(String[] args) {
		final int N = 6;
		int [][]ma = new int[20][100];
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[i].length; j++) {
				System.out.print(ma[i][j]);
			}
			System.out.println();
		}

	/*	
		ThMatriz [][]matriz = new ThMatriz[20][100];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = new ThMatriz((i+1));
				matriz[i][j].start();
			}
			
		for (int i1 = 0; i1 < matriz.length; i1++) {
			for (int j = 0; j < matriz[i].length; j++) {
				try {
					matriz[i1][j].join();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		}*/
	}

}
