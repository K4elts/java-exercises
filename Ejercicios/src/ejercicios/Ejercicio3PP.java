package ejercicios;

import java.util.Random;

public class Ejercicio3PP {

	public static void main(String[] args) {
		
		int[] n1 = new int[100000];
		int[] n2 = new int[100000];
		Random r = new Random();
		System.out.println("Rellenando numeros...");
		for (int i = 0; i < n1.length; i++) {
			n1[i] = r.nextInt(1000)+1;
			n2[i] = r.nextInt(1000)+1;
		}
		System.out.println("arrays rellenados");
		System.out.println("Ordenando");
		long tiempoinicial = System.currentTimeMillis();
		Ordenar.ordenar(n1);
		Ordenar.ordenar(n2);
		long tiempofinal = System.currentTimeMillis();
		System.out.println("El tiempo en ordenar los arrays son: "+(tiempofinal-tiempoinicial)/1000);
		
	}

}
