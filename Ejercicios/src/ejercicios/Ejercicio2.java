package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/*Crea un programa que muestre los procesos que tiene el sistema y nos vaya
preguntando por cada uno de ellos si lo queremos eliminar. Haz que funcione tanto
en Windows.*/
public class Ejercicio2 {

	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		Process p;
		Scanner sc = new Scanner(System.in);
		Process p2;
		
		try {
			p = r.exec("tasklist /fo csv /nh");
			String linea,pid;
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
			while ((linea=br.readLine()) != null) {
				System.out.println(linea);
				pid = linea.split(",")[1];
				System.out.println("Desea eliminar el proceso?: ");
				String proc = sc.nextLine();
				if(proc.equalsIgnoreCase("s")) {
					p2 = r.exec("taskkill /pid "+pid);
					System.out.println("Proceso eliminado");
					}
				
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
