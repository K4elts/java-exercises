package orden;

public class RnHilos implements Runnable{
	
	int idHilo;
	Almacen al;
	public RnHilos(int id,Almacen a) {
		this.idHilo = id;
		this.al = a;
	}

	@Override
	public void run() {

		al.escribeOrden(idHilo);
		
		
	}

}
