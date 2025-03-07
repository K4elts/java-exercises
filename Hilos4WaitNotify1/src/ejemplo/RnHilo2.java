package ejemplo;

public class RnHilo2 implements Runnable{

	Almacen al;
	public RnHilo2(Almacen a) {
		this.al = a;
	}
	
	@Override
	public void run() {

		this.al.escribeHilo(2);
	}

}
