package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ProgramaVisual extends JFrame {

	private JPanel contentPane;
	private JTextField tfSaludo;
	private JButton btnSaludo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramaVisual frame = new ProgramaVisual();
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
	public ProgramaVisual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSaludo = new JButton("New button");
		btnSaludo.setBounds(33, 55, 89, 23);
		contentPane.add(btnSaludo);
		
		tfSaludo = new JTextField();
		tfSaludo.setBounds(191, 56, 185, 60);
		contentPane.add(tfSaludo);
		tfSaludo.setColumns(10);
		
		btnSaludo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfSaludo.setText("Hola");
				
			}
		});
	}
}
