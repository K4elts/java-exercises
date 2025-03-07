package orden;



public class Almacen {
	
	int contador = 1;

	public synchronized void escribeOrden(int id) {	
		
		while (contador != id) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		contador++;
		notifyAll();
		
		
		System.out.println("Soy el hilo "+id);
	}
}
