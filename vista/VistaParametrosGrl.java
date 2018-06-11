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

public class VistaParametrosGrl extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5850130168373878777L;
	
	private JPanel contentPane;
	private JTextField txtVencPass;
	
	static private VistaParametrosGrl instancia;

	static public VistaParametrosGrl getInstancia() {
		if (instancia == null) {
			instancia = new VistaParametrosGrl();
		}
		return instancia;
	}

	/**
	 * Create the frame.
	 */
	private VistaParametrosGrl() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVencPass = new JLabel("VENCIMIENTO DE PASSWORD");
		lblVencPass.setBounds(6, 6, 196, 26);
		contentPane.add(lblVencPass);
		
		/*
		txtVencPass = new JTextField();
		txtVencPass.setBounds(198, 6, 130, 26);
		contentPane.add(txtVencPass);
		txtVencPass.setColumns(10);
		txtVencPass.setText(UsuarioController.getInstancia().cargarExpiracionPass());
		*/
		
		JLabel lblMensaje = new JLabel(" ");
		lblMensaje.setBounds(6, 82, 322, 26);
		contentPane.add(lblMensaje);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int error1 = UsuarioController.getInstancia().guardarExpiracionPass(txtVencPass.getText());
				int error1 = 0;
				if (error1==0)
					lblMensaje.setText("Modificacion correcta.");
				else
					lblMensaje.setText("Error al modificar.");
			}
		});
		btnModificar.setBounds(104, 65, 117, 29);
		contentPane.add(btnModificar);
	}
}
