package escribe;

public class Th123 extends Thread{
	
	Almacen almacen;
	int idHilo;
	
	public Th123(Almacen a,int id) {
		this.almacen = a;
		this.idHilo = id;
	}
	
	public void run() {
		
		while (true) {
			switch (this.idHilo) {
			case 1:
				this.almacen.escribeUno();
				break;
			case 2:
				this.almacen.escribeDos();
				break;
			case 3:
				this.almacen.escribeTres();
				break;
			default:
				break;
			}
		}
	}

}
