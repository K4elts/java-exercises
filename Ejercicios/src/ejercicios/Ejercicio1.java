package ejercicios;

import java.util.Iterator;
import java.util.Properties;

public class Ejercicio1 {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		
		System.out.println("El numero de procesadores es: "+r.availableProcessors());
		System.out.println("La memoria usada es: "+r.freeMemory()/1024/1024+"MB");
		System.out.println("La memoria maxima es: "+r.maxMemory()/1024/1024+"MB");
		System.out.println("Memoria disponible: "+r.totalMemory()/1024/1024+"MB");
		
		System.out.println("-----------------------------------------------------------");
		
		Properties propiedades = System.getProperties();
		String clave;
		Integer lineas = 0;
		//iterator sera un objeto que nos permitira recorrer(iterar) a traves del conjunto de claves del objeto propiedades
		Iterator<Object> iterator = propiedades.keySet().iterator();
		while (iterator.hasNext()) {
			clave = (String)iterator.next();
			System.out.println(lineas.toString()+": "+clave+":"+propiedades.getProperty(clave));
			lineas++;
		}
		
	}

}
