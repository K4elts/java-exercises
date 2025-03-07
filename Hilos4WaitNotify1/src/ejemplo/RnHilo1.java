package ejemplo;

public class RnHilo1 implements Runnable{

	Almacen al;
	public RnHilo1(Almacen a) {
		this.al = a;
	}
	
	@Override
	public void run() {
		
		this.al.escribeHilo(1);
		
	}

}
