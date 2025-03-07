package ejercicios;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		
		int[] a1 = new int[100000];
		int[] a2 = new int[100000];

		
		
		double tiempoinicial =System.currentTimeMillis()/1000;
		for (int i = 0; i < a1.length; i++) {
			a1[i] = (int)(Math.random()*1000);
			Arrays.sort(a1);
		}
		for (int i = 0; i < a2.length; i++) {
			a1[i] = (int)(Math.random()*1000);
			Arrays.sort(a2);
		}
		for (int i = 0; i < a1.length; i++) {
			System.out.println(a1[i]+" ");
		}
		for (int i = 0; i < a2.length; i++) {
			System.out.println(a2[i]+" ");
		}
		
		/*for(int i=0;i<a1.length;i++) {
			
			a1[i] = (int) (Math.random()*1000);
			Arrays.sort(a1);
			a2[i] = (int) (Math.random()*1000);
			System.out.print(a1[i]+" ");
			System.out.println();
			System.out.print(a2[i]+" ");	
		}*/
	
		double tiempofinal = System.currentTimeMillis()/1000;
		System.out.println();
		System.out.println(tiempofinal-tiempoinicial+"s");
	}

}
