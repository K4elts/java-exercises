package ejemplo;

public class RnHilo3 implements Runnable{

	Almacen al;
	public RnHilo3(Almacen a) {
		this.al = a;
	}
	
	@Override
	public void run() {

		this.al.liberaHilos(3);
		
	}

}
