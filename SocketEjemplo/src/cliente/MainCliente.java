package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {
	
	public static void main(String[] args) {
		
		String ip;
		int puerto;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ip del servidor: ");
		ip = sc.nextLine();
		System.out.println("Introduce el numero del puerto");
		puerto = sc.nextInt();
		Socket socket = null;
		DataOutputStream dossalida = null;
		try {
			socket = new Socket(ip,puerto);
			dossalida = new DataOutputStream(socket.getOutputStream());
			while(true) {
				System.out.println("Escribe un mensaje: ");
				dossalida.writeUTF(sc.nextLine());
			}
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		try {
			if (socket != null)socket.close();
			if (dossalida != null)dossalida.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
