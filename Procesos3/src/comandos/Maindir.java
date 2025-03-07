package comandos;

import java.io.IOException;
import java.io.InputStream;

public class Maindir {

	public static void main(String[] args) throws IOException {
		
		Runtime r = Runtime.getRuntime();

		Process p;
		
		p = r.exec("CMD /C DIR");
			
		InputStream is = p.getInputStream();
		int c;
		while ((c=is.read()) != -1) {
			System.out.print((char)c);
			}
		
		try {
			int valor = p.waitFor();
			if (valor == 0) {
				System.out.println("Comando ejecutado correctamente: "+valor);
			}else {
				System.out.println("Comando no ejecutado correctamente: "+valor);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
