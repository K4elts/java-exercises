package ejemplo;

public class Almacen {

	public synchronized void escribeHilo(int id) {
	
		System.out.println("Soy el hilo "+id+" y me voy a dormir");
		try {
			wait();//para el hilo y se va a dormir
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Soy el hilo "+id+" y me han liberado");
	}
	
	public synchronized void liberaHilos(int id) {
		System.out.println("Soy el hilo 3 y vengo a liberaros");
		if (id ==3) {
			notifyAll();//libera a un hilo de los que estén esperando en el wait
		}
	}
}
