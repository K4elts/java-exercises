package ejemplo;

public class Main {

	public static void main(String[] args) {
		
		Almacen al = new Almacen();
		
		Thread []th = new Thread[3];
		th[0] = new Thread(new RnHilo1(al));
		th[0].start();
		th[1] = new Thread(new RnHilo2(al));
		th[1].start();
		th[2] = new Thread(new RnHilo3(al));
		th[2].start();

	}

}
