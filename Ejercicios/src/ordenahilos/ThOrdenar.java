package ordenahilos;

public class ThOrdenar extends Thread{
	
	private int []v;
	private int nHilo;
	
	public ThOrdenar(int []a,int h) {
		v = a;
		this.nHilo = h;
	}
	@Override
	public void run() {
		Ordenar.ordenar(v);
		System.out.println("Ha terminado el hilo: "+this.nHilo);
	}
	
}
