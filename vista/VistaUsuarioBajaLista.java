package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;


import controlador.ListaController;
import controlador.UsuarioController;
import modelo.Lista;
import modelo.Usuario;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

public class VistaUsuarioBajaLista extends JFrame {
	
	private JFrame frame;
	
	private static final long serialVersionUID = 1998200239000713050L;
	private JTextField textFieldUsuario;

	public VistaUsuarioBajaLista() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 335);
		frame.setResizable(false);
		frame.setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBuscarListasEn = new JLabel("Buscar listas en la que participo:");
		lblBuscarListasEn.setBounds(20, 11, 208, 14);
		frame.getContentPane().add(lblBuscarListasEn);
		
		JList<String> list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setBounds(30, 36, 117, 189);
		frame.getContentPane().add(list);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(176, 242, 255, 18);
		frame.getContentPane().add(labelResultado);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(238, 7, 89, 23);
		frame.getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel<String> dml = new DefaultListModel<String>();
				ArrayList<Lista> listas = new ArrayList<>();
				/*
				Usuario usr = UsuarioController.getInstancia().getUsuarioLogueado();
				listas = ListaController.getInstancia().buscarParticipanteEnLista(usr.getNombreDeUsuario());
				*/
				listas = ListaController.getInstancia().buscarParticipanteEnLista(textFieldUsuario.getText());
				for (int i = 0; i<listas.size(); i++){
					dml.addElement(listas.get(i).getNombreLista());
				}
				list.setModel(dml);
				if (list.getModel().getSize()== 0)
					labelResultado.setText("El usuario no participa en ninguna lista");
			}
		});
		
		JTextArea txtrSeleccionarListaY = new JTextArea();
		txtrSeleccionarListaY.setBackground(SystemColor.control);
		txtrSeleccionarListaY.setText("Seleccione la lista a la cual \r\nquiere dejar de participar y \r\nluego haga click en el \r\nbot\u00F3n \"Baja\"");
		txtrSeleccionarListaY.setBounds(199, 80, 203, 98);
		frame.getContentPane().add(txtrSeleccionarListaY);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setBounds(30, 256, 89, 23);
		frame.getContentPane().add(btnBaja);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setText("Usuario");
		textFieldUsuario.setBounds(238, 41, 86, 20);
		frame.getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String seleccionado = (String) list.getSelectedValue();
				Lista l = ListaController.getInstancia().buscarLista(seleccionado);
				//l.quitarParticipante(UsuarioController.getInstancia().getUsuarioLogueado().getNombreDeUsuario());
				l.quitarParticipante(textFieldUsuario.getText());
				labelResultado.setText("Salista de la lista seleccionada");
			}
		});
	}
}
