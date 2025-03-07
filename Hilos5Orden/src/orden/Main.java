package orden;

public class Main {

	public static void main(String[] args) {
		
		Almacen al = new Almacen();

		Thread []rnh = new Thread[10];
		for (int i = 0; i < rnh.length; i++) {
			rnh[i] = new Thread(new RnHilos((i+1),al));
			rnh[i].start();
		}
		
	}

}
