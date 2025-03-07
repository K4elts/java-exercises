package runtimeproceso;

import java.io.IOException;

public class MainRuntimeProceso {

	public static void main(String[] args) {

		//AQUI SE INICIA UN PROCESO
		Runtime r = Runtime.getRuntime();
		
		String comand = "NOTEPAD";
		Process p;
		
		try {
			p = r.exec(comand);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
