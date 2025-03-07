package cajero;

import java.util.Random;

public class RnCliente implements Runnable{

	Cajero cajeroAutomatico;
	private int idCliente;
	
	public RnCliente(int id,Cajero caj) {
		this.idCliente = id;
		this.cajeroAutomatico = caj;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			this.cajeroAutomatico.extraer(this.idCliente, (r.nextInt(5)+1)*20);
		}
	}

}
