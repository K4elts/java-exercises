package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import chat.Mensaje;


public class Servidor {

	private int numPort;
	private HashMap<String, ObjectOutputStream> hmUsuarios;
	
	public Servidor(int numPuerto) {
		this.numPort = numPuerto;
		this.hmUsuarios = new HashMap<String,ObjectOutputStream>();
	}

	public void arrancar() {
		ServerSocket serverSocket = null;
		Socket socketCliente = null;
		
		try {
			serverSocket = new ServerSocket(this.numPort);
			while (true) {
				socketCliente = serverSocket.accept();
				Thread thCliente = new Thread(new RnCliente(socketCliente));
				thCliente.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (socketCliente != null)socketCliente.close();
			if (serverSocket != null)serverSocket.close();
		} catch (IOException e) {
			System.out.println("Hubo un error en el servidor.");
		}
	}
	
	class RnCliente implements Runnable {
		
		private Socket socket;
		private ObjectOutputStream oossalida;
		private ObjectInputStream oisentrada;
		
		public RnCliente(Socket socketCliente) {
			this.socket = socketCliente;
			
		}

		@Override
		public void run() {
			String cliente = null;
			Mensaje mensaje = null;
			try {
				oisentrada = new ObjectInputStream(socket.getInputStream());
				oossalida = new ObjectOutputStream(socket.getOutputStream());
				
				mensaje = (Mensaje) oisentrada.readObject();
				if (mensaje.getTipo() == Mensaje.IDENTIFICATION_USUARIO) {
					if (existeUsuario(mensaje.getnombreUsuario())) {
						oossalida.writeObject(new Mensaje(Mensaje.USUARIO_EXISTE,null,null,null));
					}else {
						//obtenemos el nombre del cliente
						cliente = mensaje.getnombreUsuario();
						oossalida.writeObject(new Mensaje(Mensaje.USUARIO_VALIDO,null,null,null));
						//añadimos el nuevo cliente al hashmap
						anadirUsuario(cliente,oossalida);
						
						ArrayList<String> alNombres = new ArrayList<String>(getUsuarios());
						
						oossalida.writeObject(new Mensaje(Mensaje.LISTA_USUARIOS_CONECTADOS,null,null,alNombres));
						//Enviar broadcast de usuarios nuevos
						broadcast(new Mensaje(Mensaje.NUEVO_USUARIO_CONECTADO,cliente,null,null));
						
						while(true) {
							mensaje = (Mensaje) oisentrada.readObject();
							if (mensaje.getTipo() == Mensaje.MENSAJE) {
								broadcast(mensaje);
							}
						}
					}
				}
			} catch (IOException e) {
				//fallo de conexion
				eliminarUsuario(cliente);
				broadcast(new Mensaje(Mensaje.USUARIO_DESCONECTADO,cliente,null,null));
				System.out.println("Ha salido el usuario "+cliente);
			} catch (ClassNotFoundException e) {
				System.out.println("Error de conexion");
				e.printStackTrace();
			}
			
			try {
				if (oisentrada != null)oisentrada.close();
				if (oossalida != null)oossalida.close();
				if (socket != null)socket.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
			
		}

		private synchronized void eliminarUsuario(String cliente) {
			hmUsuarios.remove(cliente);
			
		}
		
	}
	
	public synchronized boolean existeUsuario(String nuevoUsuario) {
		return this.hmUsuarios.containsKey(nuevoUsuario);
	}
	
	public synchronized void anadirUsuario(String nombre,ObjectOutputStream salida) {
		this.hmUsuarios.put(nombre, salida);
	}
	
	public synchronized Set<String> getUsuarios() {
		return this.hmUsuarios.keySet();
	}
	
	public synchronized void broadcast(Mensaje men) {
		Iterator iterator = hmUsuarios.keySet().iterator();
		String nombre;
		while (iterator.hasNext()) {
			nombre = (String) iterator.next();
			try {
				this.hmUsuarios.get(nombre).writeObject(men);
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}

}
