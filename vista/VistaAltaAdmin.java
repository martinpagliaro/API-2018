package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.UsuarioController;


public class VistaAltaAdmin extends JFrame {

	private static final long serialVersionUID = -3173593118178927673L;
		
	private JPanel contentPane;
	private JTextField textNombreDeUsuario;
	private JTextField textPassword;
	static private VistaAltaAdmin instancia;
	
	static public VistaAltaAdmin getInstancia() {
		if (instancia == null) {
			instancia = new VistaAltaAdmin();
		}
		return instancia;
	}
	
	public VistaAltaAdmin() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Crear Admin");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUsuario = new JLabel("Nombre");
		lblUsuario.setBounds(10, 19, 65, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 54, 65, 14);
		contentPane.add(lblContrasea);
		
		textNombreDeUsuario = new JTextField();
		textNombreDeUsuario.setBounds(87, 16, 86, 20);
		contentPane.add(textNombreDeUsuario);
		textNombreDeUsuario.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(87, 51, 86, 20);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(12, 134, 161, 14);
		contentPane.add(labelResultado);
		
		JButton btnCrearAdmin = new JButton("Crear Admin");
		btnCrearAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreDeUsuario = textNombreDeUsuario.getText();
				String passwordString = textPassword.getText();
				int error = UsuarioController.getInstancia().altaAdministrador(nombreDeUsuario, passwordString);
				switch (error) {
					case 0:
						labelResultado.setText("Admistrador creado");
						textNombreDeUsuario.setText("");
						textPassword.setText("");
						//VistaAltaUsuario.getInstancia().setVisible(false);
						break;
					case 1:
						labelResultado.setText("El nombre de usuario ya existe.");
						textNombreDeUsuario.selectAll();
						break;
				}
			}
		});
		btnCrearAdmin.setBounds(10, 100, 161, 23);
		contentPane.add(btnCrearAdmin);
	
	}
}
