package pila;

import java.util.Random;

public class RnPonerElementos implements Runnable{
	
	private Elementos elementos;
	private static Boolean parar = false;
	
	public RnPonerElementos(Elementos el) {
		this.elementos = el;
	}

	@Override
	public void run() {
		Random r = new Random();
		while(true && (!parar)) {	
			int num = r.nextInt(10);
			boolean pudoInsertar =  elementos.ponerElemento(num);
			if (pudoInsertar) {
				System.out.println("El numero "+num+" se pudo insertar");
			}else {
				System.out.println("El numero "+num+" no se pudo insertar");
			}
		}
		
	}
	
	public static boolean isParar() {
		return parar;
	}
	
	public static void setParar(Boolean parar) {
		RnPonerElementos.parar = parar;
	}

}
