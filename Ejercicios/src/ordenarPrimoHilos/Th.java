package ordenarPrimoHilos;

public class Th extends Thread{
	
	private int v;
	
	public Th(int a) {
		v = a;
	}
	
	@Override
	public void run() {
		//Primos.primos(v);
	}
	
}
