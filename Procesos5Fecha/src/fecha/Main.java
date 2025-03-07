package fecha;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Runtime r = Runtime.getRuntime();
		
		//ProcessBuilder pb = new ProcessBuilder("CMD","/C","DATE");
		File f = new File(".//bin");
		ProcessBuilder pb = new ProcessBuilder("java","ejemplolectura.Main");
		pb.directory(f);
		
		
		Process p = pb.start();
		OutputStream os = p.getOutputStream();
		//os.write("02-12-22".getBytes());//lo transforma en bytes (.getBytes) y lo mete en el buffer
		os.write("Ana\n".getBytes());//se necesita el \n para que funcione
		os.flush();//lo escribe en el proceso
		InputStream is = p.getInputStream();
		
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char)c);
		}
		is.close();
		
		InputStream isError = p.getErrorStream();
		String texto = "";
		int cerr;
		while ((cerr = isError.read()) != -1) {
			texto = texto + (char)cerr;
		}
		System.out.println(texto);
		isError.close();
		
		try {
			int salida = p.waitFor();
			if(salida == 0) {
				System.out.println("Se ejecutó correctamente");
			}else {
				System.out.println("Hubo un fallo");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
