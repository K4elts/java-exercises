package practica1;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		ProcessBuilder pb = new ProcessBuilder("cmd","/c","brave.exe");
		try {
			Process p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
