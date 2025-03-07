package llamadaunsaludo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class LlamadaUnSaludo {

	public static void main(String[] args) throws IOException {
		
		Runtime r = Runtime.getRuntime();
		
		File ruta = new File(".//bin");
		ProcessBuilder pb = new ProcessBuilder("java","saludo.Unsaludo","Ana");
		
		pb.directory(ruta);
		Process p = pb.start();
		InputStream is = p.getInputStream();
		
		File f = new File("LlamadaUnSaludo.txt");
		FileWriter fw = new FileWriter(f);
		int c;
		
		while ((c = is.read()) != -1) {
			
			fw.write((char)c);
		}
		fw.close();
		is.close();
		
		/*
		String texto = "";
		int c;
		while ((c = is.read()) != -1) {
			texto = texto + (char)c;
		}
		System.out.println(texto);
		*/
		try {
			int salida = p.waitFor();
			if (salida == 0) {
				System.out.println("El programa se ejecutó correctamente");
			}else if(salida == 1) {
				System.out.println("Ocurrió un problema");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
