package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el puerto de escucha");
		int puerto = sc.nextInt();
		sc.close();
		ServerSocket serverSocket = null;
		Socket socket = null;
		DataInputStream DISentrada = null;
		DataOutputStream DOSsalida = null;
		
		try {
			serverSocket = new ServerSocket(puerto);
			System.out.println("Servidor escuchando en el puerto: "+puerto);
			socket = serverSocket.accept();
			System.out.println("Entró un cliente");
			DISentrada = new DataInputStream(socket.getInputStream());
			DOSsalida = new DataOutputStream(socket.getOutputStream());
			String texto;
			while((texto = DISentrada.readUTF()) != null) {
				System.out.println("El mensaje recibido del cliente es: "+texto);
				DOSsalida.writeUTF("Soy el servidor y me ha llegado tu mensaje");
			}
			
		} catch (IOException e) {
			System.out.println("Error en la comunicacion");
		}
		try {
			if (DISentrada != null)DISentrada.close();
			if (DOSsalida != null)DOSsalida.close();
			if (socket != null)socket.close();
			if (serverSocket != null)serverSocket.close();
			
		}catch(IOException e) {
			
		}
		
	}

}
