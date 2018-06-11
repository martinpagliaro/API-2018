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

public class VistaMenuUsr extends JFrame {
	
	private static final long serialVersionUID = 9144541504916134590L;
	
	static private VistaMenuUsr instancia;
	private JPanel contentPane;
	
	public static void main(String[] args) 
	{
		VistaMenuUsr inst = new VistaMenuUsr();
		inst.setVisible(true);
	}
	
	public VistaMenuUsr()
	{
		initGUI();
	}

	

	static public VistaMenuUsr getInstancia() {
		if (instancia == null) {
			instancia = new VistaMenuUsr();
		}
		return instancia;
	}
	
	/**
	 * Create the frame.
	 */
	
	//Cambiar por VistaMenuUsr y quitar el void
	private void initGUI() {
		
		/*
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent arg0) {
				cargarDatosUsuario();
			}
		});
		*/
		
		setTitle("Sistema de gestion de regalos - Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Listas");
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmBajaParticipante = new JMenuItem("Baja");
		mntmBajaParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaUsuarioLista vul = new VistaUsuarioLista();
				vul.setVisible(true);
			}
		});
		mnUsuarios.add(mntmBajaParticipante);
		
		JMenu mnLista = new JMenu("Pagos");
		menuBar.add(mnLista);
		
		JMenuItem mntmAltaLista = new JMenuItem("Pagar");
		mnLista.add(mntmAltaLista);
		mntmAltaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnLista.add(mntmAltaLista);
		
	}
	
	/*
	private void cargarDatosUsuario(){
		UsuarioView vul = UsuarioController.getInstancia().getLoggedUserView();
		lblUsuarioLogueado.setText(vul.getNombre());
	}
	*/
}
