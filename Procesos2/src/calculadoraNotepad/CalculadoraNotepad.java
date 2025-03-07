package calculadoraNotepad;

import java.io.IOException;
import java.io.InputStream;

public class CalculadoraNotepad {

	public static void main(String[] args) throws IOException {

		Process p = new ProcessBuilder("cmd.exe","/c","ipconfig /all").start();
		
		InputStream is = p.getInputStream();
		int c;
		while ((c=is.read()) != -1) {
			System.out.print((char)c);
			}
			is.close();
			//System.exit(0);
			
		
		InputStream isError = p.getErrorStream();
		String texto = "";
		int cerr;
		while ((cerr = isError.read()) != -1) {
			texto = texto + (char)cerr;
		}
		//System.out.println("El error producido ha sido: "+texto);
		isError.close();
		//System.exit(1);
		//System.out.println("adios"); //esto se no se ejecuta porque en la linea anterior salimos del programa con salida 1
		if (texto.equals("")) {
			System.exit(0);
		}else {
			System.out.println("El error producido ha sido: "+texto);
			System.exit(1);
		}
		/*
		Process p = new ProcessBuilder("cmd.exe","/c","ipconfigsrd /all").start();
		InputStream is = p.getInputStream();
		int c;
		
		if ((c=is.read()) != -1) {
		//if ((c=is.read()) != -1) {
			while ((c=is.read()) != -1) {
				System.out.print((char)c);
				}
			System.out.println("El proceso se ha ejecutado correctamente");
			System.exit(0);
				is.close();
				
		}else {
			InputStream isError = p.getErrorStream();
			String texto = "";
			int cerr;
			while ((cerr = isError.read()) != -1) {
				texto = texto + (char)cerr;
			}
			System.out.println("El error producido ha sido: "+texto);
			System.exit(1);
			isError.close();
			
		}*/
	}

}
