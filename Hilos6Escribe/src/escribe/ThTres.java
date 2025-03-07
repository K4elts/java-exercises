package escribe;

public class ThTres extends Thread{

	Almacen almacen;
	
	public ThTres(Almacen al) {
		this.almacen=al;
	}
	
	public void run() {
		while (true) {
			this.almacen.escribeTres();
		}
	}
}
