package escribe;

public class Almacen {
	
	private final int TURNO_UNO = 1;
	private final int TURNO_DOS = 2;
	private final int TURNO_TRES = 3;
	private int turnoActual = TURNO_UNO;
	
	public synchronized void escribeUno() {
		if (turnoActual == TURNO_UNO) {
			System.out.println("UNO");
			turnoActual = TURNO_DOS;
		}
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void escribeDos() {
		if (turnoActual == TURNO_DOS) {
			System.out.println("DOS");
			turnoActual = TURNO_TRES;
		}
		notify();
		try {
			wait();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void escribeTres() {
		if (turnoActual == TURNO_TRES) {
			System.out.println("TRES");
			turnoActual = TURNO_UNO;
		}
		notify();
		try {
			wait();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
