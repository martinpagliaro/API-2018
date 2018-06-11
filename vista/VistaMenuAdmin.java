package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controlador.UsuarioController;
import controlador.UsuarioView;

public class VistaMenuAdmin extends JFrame {
	
	private static final long serialVersionUID = 9144541504916134590L;
	
	static private VistaMenuAdmin instancia;
	private JPanel contentPane;
	private JLabel lblUsuarioLogueado;

	

	static public VistaMenuAdmin getInstancia() {
		if (instancia == null) {
			instancia = new VistaMenuAdmin();
		}
		return instancia;
	}
	
	/**
	 * Create the frame.
	 */
	private VistaMenuAdmin() {
		/*addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent arg0) {
				cargarDatosUsuario();
			}
		});*/
		
		setTitle("Sistema de gestion de regalos - Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Crear usuario");
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaAltaUsuario vmu = new VistaAltaUsuario();
				vmu.setVisible(true);
			}
		});
		mnUsuarios.add(mntmAltaUsuario);
		
		JMenuItem mntmModificarUsuario = new JMenuItem("Modificar usuario");
		mntmModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaModificarUsuario vmu = new VistaModificarUsuario();
				vmu.setVisible(true);
			}
		});
		
		JMenuItem mntmCrearAdmin = new JMenuItem("Crear administrador");
		mnUsuarios.add(mntmCrearAdmin);
		mnUsuarios.add(mntmModificarUsuario);
		mntmCrearAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaAltaAdmin.getInstancia().setVisible(true);
			}
		});
		
		JMenuItem mntmBajaUsuario = new JMenuItem("Eliminar usuario");
		mntmBajaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaBajaUsuario vmu = new VistaBajaUsuario();
				vmu.setVisible(true);
			}
		});
		mnUsuarios.add(mntmBajaUsuario);
		
		JMenuItem mntmModificarPara = new JMenuItem("Modificar par\u00E1metros");
		mnUsuarios.add(mntmModificarPara);
		mntmModificarPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaParametrosGrl.getInstancia().setVisible(true);
			}
		});
				
		JMenu mnLista = new JMenu("Listas");
		menuBar.add(mnLista);
		
		JMenuItem mntmAltaLista = new JMenuItem("Crear lista");
		mnLista.add(mntmAltaLista);
		mntmAltaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaAltaLista vmu = new VistaAltaLista();
				vmu.setVisible(true);
			}
		});
		mnLista.add(mntmAltaLista);
		
		JMenuItem mntmModificarLista = new JMenuItem("Modificar lista");
		mnLista.add(mntmModificarLista);
		mntmModificarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaModificarLista vmu = new VistaModificarLista();
				vmu.setVisible(true);
			}
		});
		mnLista.add(mntmModificarLista);
		
		JMenuItem mntmBajaLista = new JMenuItem("Eliminar lista");
		mnLista.add(mntmBajaLista);
		mntmBajaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaBajaLista vmu = new VistaBajaLista();
				vmu.setVisible(true);
			}
		});
		mnLista.add(mntmBajaLista);
		
		JMenuItem mntmAgregarParticipantes = new JMenuItem("Agregar participantes");
		mnLista.add(mntmAgregarParticipantes);
		mntmAgregarParticipantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VistaAgregarParticipantes vmu = new VistaAgregarParticipantes();
				//vmu.setVisible(true);
			}
		});
		mnLista.add(mntmAgregarParticipantes);
		
	}
	
	private void cargarDatosUsuario(){
		UsuarioView vul = UsuarioController.getInstancia().getLoggedUserView();
		lblUsuarioLogueado.setText(vul.getNombre());
	}
}
