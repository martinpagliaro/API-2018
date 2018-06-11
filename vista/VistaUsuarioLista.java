package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

public class VistaUsuarioLista extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	
	private static final long serialVersionUID = 1998200239000713050L;

	
	public VistaUsuarioLista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 335);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBuscarListasEn = new JLabel("Buscar listas en la que participo:");
		lblBuscarListasEn.setBounds(20, 11, 208, 14);
		frame.getContentPane().add(lblBuscarListasEn);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(238, 7, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JList list = new JList();
		list.setBounds(30, 36, 117, 189);
		frame.getContentPane().add(list);
		
		JTextArea txtrSeleccionarListaY = new JTextArea();
		txtrSeleccionarListaY.setBackground(SystemColor.control);
		txtrSeleccionarListaY.setText("Seleccione la lista a la cual \r\nquiere dejar de participar y \r\nluego haga click en el \r\nbot\u00F3n \"Baja\"");
		txtrSeleccionarListaY.setBounds(199, 80, 203, 98);
		frame.getContentPane().add(txtrSeleccionarListaY);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setBounds(30, 256, 89, 23);
		frame.getContentPane().add(btnBaja);
	}
}
