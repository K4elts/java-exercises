package cajero;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero de clientes");
		int nClientes = sc.nextInt();
		int saldoReposicion;
		
		do {
			System.out.println("Introduce una cantidad multiplo de 20 y distinto de 0");
			saldoReposicion = sc.nextInt();
			
		} while ((saldoReposicion % 20 != 0)||(saldoReposicion == 0));
		
		Cajero cajeroAutomatico = new Cajero();
		
		new Thread(new RnReponedor(saldoReposicion,cajeroAutomatico)).start();
		
		for (int i=0;i<nClientes;i++) {
			new Thread(new RnCliente((i+1),cajeroAutomatico));
		}
	}

}
