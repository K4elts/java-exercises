package escribe;

public class ThDos extends Thread{
	
	Almacen almacen;
	
	public ThDos(Almacen al) {
		this.almacen=al;
	}
	
	public void run() {
		while (true) {
			this.almacen.escribeDos();
		}
	}
}
