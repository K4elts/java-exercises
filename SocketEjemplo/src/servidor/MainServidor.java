package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServidor {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el puerto por el que escuchará");
		int puerto = sc.nextInt();
		DataInputStream disentrada = null;
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(puerto);
			socket = serverSocket.accept();
			disentrada = new DataInputStream(socket.getInputStream());
			String texto = disentrada.readUTF();
			while(texto != null) {
				System.out.println(disentrada);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(socket != null)socket.close();
			if(serverSocket != null)serverSocket.close();
			if(disentrada != null)disentrada.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
