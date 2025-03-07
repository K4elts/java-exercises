package cajero;

public class RnReponedor implements Runnable {

	private Cajero c;
	private int saldoReponer;
	
	public RnReponedor(int cantidad, Cajero caj) {
		this.saldoReponer = cantidad;
		this.c = caj;
	}
	
	@Override
	public void run() {

		while(true) {
			c.reponer(saldoReponer);
		}
	}
	

}
