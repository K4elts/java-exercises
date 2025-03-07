package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RnCliente implements Runnable {

	Socket socket;
	int numCliente;
	
	public RnCliente(Socket soc, int num) {
		this.socket = soc;
		this.numCliente = num;
	}
	
	@Override
	public void run() {
		DataInputStream disentrada = null;
		//DataOutputStream dossalida = null;
		try {
			disentrada = new DataInputStream(socket.getInputStream());
			//dossalida = new DataOutputStream(socket.getOutputStream());
			
			while(true) {
				System.out.println("El cliente "+this.numCliente+" dice: "+disentrada.readUTF());
			}
		} catch (IOException e) {
			System.out.println("Cliente "+this.numCliente+" se ha desconectado");
		}
		try {
			if (disentrada != null)disentrada.close();
			if (socket != null)socket.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

}
