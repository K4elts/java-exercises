package escribe;

public class ThUno extends Thread{
	
	Almacen almacen;
	
	public ThUno(Almacen al) {
		this.almacen=al;
	}
	
	public void run() {
		while (true) {
			this.almacen.escribeUno();
		}
	}
}
