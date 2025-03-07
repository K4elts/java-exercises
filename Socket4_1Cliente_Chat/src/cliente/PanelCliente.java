package cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chat.Mensaje;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCliente extends JFrame {

	private JPanel contentPane;
	
	private Socket socket;
	
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	
	private ArrayList<String> alUsuarios;
	
	JTextArea taServidor;
	JTextArea taPuerto;
	JTextArea taConsola;
	JTextArea taUsuarios;
	JTextArea taEnviar;
	JTextArea taNombre_Usuario;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelCliente frame = new PanelCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelCliente() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Servidor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(77, 32, 76, 35);
		contentPane.add(lblNewLabel);
		
		taServidor = new JTextArea();
		taServidor.setBounds(180, 32, 180, 35);
		contentPane.add(taServidor);
		
		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPuerto.setBounds(77, 78, 76, 35);
		contentPane.add(lblPuerto);
		
		taPuerto = new JTextArea();
		taPuerto.setBounds(180, 78, 180, 35);
		contentPane.add(taPuerto);
		
		taConsola = new JTextArea();
		taConsola.setBounds(10, 124, 650, 300);
		contentPane.add(taConsola);
		
		JButton btConectar = new JButton("Conectar");
		btConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					socket = new Socket(taServidor.getText().toString(),Integer.parseInt(taPuerto.getText()));
					Thread thCliente = new Thread(new RnCliente());
					thCliente.setDaemon(true);
					thCliente.start();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btConectar.setBounds(754, 21, 180, 92);
		contentPane.add(btConectar);
		
		taUsuarios = new JTextArea();
		taUsuarios.setBounds(754, 124, 180, 300);
		contentPane.add(taUsuarios);
		
		JButton btEnviar = new JButton("Enviar");
		btEnviar.setBounds(571, 428, 89, 35);
		contentPane.add(btEnviar);
		
		taEnviar = new JTextArea();
		taEnviar.setBounds(10, 428, 551, 35);
		contentPane.add(taEnviar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(409, 32, 76, 35);
		contentPane.add(lblNombre);
		
		taNombre_Usuario = new JTextArea();
		taNombre_Usuario.setBounds(490, 32, 180, 35);
		contentPane.add(taNombre_Usuario);
	}
	
	private class RnCliente implements Runnable {

		@Override
		public void run() {
			Mensaje mensaje = null;
			
			try {
				salida = new ObjectOutputStream(socket.getOutputStream());
				entrada = new ObjectInputStream(socket.getInputStream());
				
				//Empeza el protocolo
				salida.writeObject(new Mensaje(Mensaje.IDENTIFICATION_USUARIO,taNombre_Usuario.getText(),null,null));
				mensaje = (Mensaje)entrada.readObject();
				if (mensaje.getTipo() == Mensaje.USUARIO_VALIDO) {
					mensaje = (Mensaje) entrada.readObject();
					
					if (mensaje.getTipo() == Mensaje.LISTA_USUARIOS_CONECTADOS) {
						//estadoConectado()
					}
				}
				
			}catch (IOException e) {
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
