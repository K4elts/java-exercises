package llamadaProcesos;

import java.io.*;

public class LlamadaProceso {

	public static void main(String[] args) throws IOException {

		File ruta = new File(".//bin");
		ProcessBuilder pb = new ProcessBuilder("java","calculadoraNotepad.CalculadoraNotepad");
		
		pb.directory(ruta);
		Process p = pb.start();
		InputStream is = p.getInputStream();
		//LINEA A LINEA
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String linea;
		while ((linea = br.readLine()) != null) {
			System.out.println(linea);
		}
		br.close();
		is.close();
		*/
		
		//CARACTER A CARACTER
		int c;
		while ((c=is.read()) != -1) {
			System.out.print((char)c);
			
		}
		is.close();
		
		try {
			int valor = p.waitFor();
			if (valor == 0) {
				System.out.println("El proceso se ha ejecutado correctamente");
			}else if (valor ==1 ) {
				System.out.println("Ha habido algun error");	
			}else {
				System.out.println("Desconocemos como se ha ejecutado ese proceso");
			}
			System.out.println("El proceso lanzado ha terminado con un: "+p.waitFor());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
