package servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServidor {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int contClientes = 0;
		System.out.println("Numero de puerto por el que escucha el servidor: ");
		int numPuerto = sc.nextInt();
		ServerSocket serverSocket = null;
		Socket socket = null;//string de conexion
		//DataOutputStream dossalida = null;
		
		try {
			serverSocket = new ServerSocket(numPuerto);
			while(true) {
				socket = serverSocket.accept();//se para en cada iteracion. espera a que entre un cliente
				
				System.out.println("Nuevo cliente conectado");
				new Thread(new RnCliente(socket,contClientes++)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error de conexion");
		}
		try {
			if (socket != null)socket.close();
			if (serverSocket != null)serverSocket.close();
			sc.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
