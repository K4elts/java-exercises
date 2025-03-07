package cajero;

public class Cajero {

	private int saldoReposicion;
	private final int TURNO_CLIENTE = 0;
	private final int TURNO_REPONEDOR = 1;
	private int turno = TURNO_REPONEDOR;
	
	public Cajero() {
		this.saldoReposicion = 0;
	}
	
	public void extraer(int idHilo, int cant) {
		
		if (turno == TURNO_CLIENTE) {
			if (this.saldoReposicion >= cant) {
			this.saldoReposicion  = this.saldoReposicion  - cant;
			System.out.println("Cliente "+idHilo+" ha sacado "+cant+" euros. Quedan "+this.saldoReposicion+" euros");
			if (this.saldoReposicion == 0) {
				turno = TURNO_REPONEDOR;
			}
			}else {
				System.out.println("No hay saldo suficiente");
			}
		}else {
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void reponer (int saldo) {
		if (turno == TURNO_REPONEDOR) {
			System.out.println("Recargado el saldo en "+saldo+" euros.");
			this.saldoReposicion = saldo;
			turno = TURNO_CLIENTE;
		}
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
