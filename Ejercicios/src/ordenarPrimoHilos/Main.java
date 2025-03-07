package ordenarPrimoHilos;

import java.util.*;


//buscar y mostrar los numeros primos del 0 al millon usando hilos
public class Main {

	public static  void main(String[] args) {
		Almacen a = new Almacen();
		final int N = 1000000;
		Runtime r = Runtime.getRuntime();
		System.out.println("El numero de cores es: "+r.availableProcessors());
		
		
		
		int numCores = r.availableProcessors();
		
		int rango = N/numCores;
		int inicioRango = 0;
		int finRango = rango;
		Primos []p = new Primos[numCores];
		long tiempoInicial = System.currentTimeMillis();
		//lanzamos tantos hilos como procesadores tengamos
		for (int i = 0; i < numCores; i++) {
			p[i] = new Primos(inicioRango,finRango,(i+1),a);
			p[i].start();
			inicioRango += rango;
			finRango += rango;
			if (i==numCores-2) {//cuando estemos en el penultimo hilo, este le dice al ultimo que termine los ultimos numeros que faltan
				finRango = N+1;
			}//if
			
		}//for
		
		for (int i = 0; i < p.length; i++) {
			try {
				p[i].join();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//for
		long tiempoFinal = System.currentTimeMillis();
		System.out.println("El tiempo empleado ha sido: "+(tiempoFinal-tiempoInicial)/1000);
		
		Iterator it = a.getIterador();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		
		
		
		
		/*int inicio = 0;
		int tope = N/6;
		System.out.println(tope);
		
		Primos h1 = new Primos(0,500000,1);
		inicio += tope;
		tope = N;
		Primos h2 = new Primos(500001,700000,2);
		
		long tiempoInicio = System.currentTimeMillis();
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		long tiempoFinal = System.currentTimeMillis();
		
		System.out.println("El tiempo empleado en encontrar los numeros primos ha sido: "+(tiempoFinal-tiempoInicio)/1000);*/
	}

}
