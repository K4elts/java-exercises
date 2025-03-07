package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {
		
		String host;
		int numPuerto;
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe la ip del servidor remoto");
		host = sc.nextLine();
		System.out.println("Escribe el numero del puerto");
		numPuerto = Integer.parseInt(sc.nextLine());
		Socket socket = null;
		DataOutputStream dossalida = null;
		DataInputStream disentrada = null;
		
		try {
			socket = new Socket(host,numPuerto);
			dossalida = new DataOutputStream(socket.getOutputStream());
			disentrada = new DataInputStream(socket.getInputStream());
			while(true) {
				System.out.println("Cadena a enviar..");
				dossalida.writeUTF(sc.nextLine());
			}
			
			
		} catch (IOException e) {
			System.out.println("Error de conexion");
		}
		try {
			if (disentrada != null)disentrada.close();
			if (dossalida != null)dossalida.close();
			if (socket != null)socket.close();
			sc.close();
			
		}catch(IOException e) {
			
		}
	}

}
