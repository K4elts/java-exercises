package chat;

import java.io.Serializable;
import java.util.ArrayList;

public class Mensaje implements Serializable {

	private final static long SERIAL_VERSION_UID = 1L;

	//tipos de mensaje
	public final static int IDENTIFICATION_USUARIO = 0;
	public final static int USUARIO_EXISTE = 1;
	public final static int USUARIO_VALIDO = 2;
	public final static int LISTA_USUARIOS_CONECTADOS = 3;
	public final static int NUEVO_USUARIO_CONECTADO = 4;
	public final static int USUARIO_DESCONECTADO = 5;
	public final static int MENSAJE = 6;

	private int tipo;
	private String nombreUsuario;
	private String mensaje;
	private ArrayList<String> ALUsuarios;

	public Mensaje(int tipo, String nombreUsuario, String mensaje, ArrayList<String> alUsuarios) {
		this.tipo = tipo;
		this.nombreUsuario = nombreUsuario;
		this.mensaje = mensaje;
		this.ALUsuarios = alUsuarios;
	}

	public int getTipo() {
		return this.tipo;
	}

	public String getnombreUsuario() {
		return this.nombreUsuario;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public ArrayList<String> getALUsuarios(){
		return this.ALUsuarios;
	}
}
