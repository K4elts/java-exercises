package ordenahilos;

import java.util.Random;

import ejercicios.Ordenar;

public class Main {

	public static void main(String[] args) {


		int[] n1 = new int[100000];
		int[] n2 = new int[100000];
		Random r = new Random();
		System.out.println("Rellenando numeros...");
		for (int i = 0; i < n1.length; i++) {
			n1[i] = r.nextInt(1000)+1;
			n2[i] = r.nextInt(1000)+1;
		}
		System.out.println("Arrays rellenados...");
		System.out.println("Ordenando");
		double tiempoinicial = System.currentTimeMillis();
		ThOrdenar h1 = new ThOrdenar(n1,0);
		ThOrdenar h2 = new ThOrdenar(n2,1);
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		double tiempofinal = System.currentTimeMillis();
		System.out.println("El tiempo en ordenar los arrays son: "+(tiempofinal-tiempoinicial)/1000);
		
		
	}

}
