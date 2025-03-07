package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.Iterator;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {

		
		//AQUI SE CAPTURA UN PROCESO
		
		Runtime runtime1 = Runtime.getRuntime(); //crea una instancia
		Runtime runtime2 = Runtime.getRuntime();
		
		System.out.println("El numero de procesadores es: "+runtime1.availableProcessors());
		System.out.println("La memoria total es: "+runtime2.totalMemory());
		long memoriaMaximaDisponible = runtime2.maxMemory();
		// ------------------------------ Propiedades del sistema ----------------------------
		
		Properties propiedades = System.getProperties();
		String clave;
		Integer lineas = 0;
		//iterator sera un objeto que nos permitira recorrer(iterar) a traves del conjunto de claves del objeto propiedades
		/*Iterator<Object> iterator = propiedades.keySet().iterator();
		while (iterator.hasNext()) {
			clave = (String)iterator.next();
			System.out.println(lineas.toString()+":"+clave+":"+propiedades.getProperty(clave));
			lineas++;
		}*/
		System.out.println("*******************************");
		long tiempoInicial = System.currentTimeMillis();
		for(int i=0; i<10;i++) {
			/*try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		long tiempoFinal = System.currentTimeMillis();
		System.out.println("El tiempo empleado en ejecutar ese for es: "+(tiempoFinal-tiempoInicial));
		System.out.println("---------------------- Lanzamos un proceso ---------------------");
		
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("cmd.exe","/c","ipconfig /all");
		
		try {
			
			Process p = pb.start();
			InputStream is = p.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea = br.readLine();
			while(linea != null) {
				System.out.println("Salida del ipconfig: "+linea);
				linea = br.readLine();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
