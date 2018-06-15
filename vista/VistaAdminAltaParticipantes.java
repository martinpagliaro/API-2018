package vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import controlador.ListaController;
import controlador.UsuarioController;
import modelo.Lista;
import modelo.Participante;
import modelo.Usuario;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class VistaAdminAltaParticipantes extends JFrame {
	
	private static final long serialVersionUID = 2991809326387498017L;
	private JFrame frame;
	private JPanel contentPane;
	static private VistaAltaLista instancia;
	private JTextField textFieldNombreLista;
	private Lista lista;
	private DefaultListModel<String> dml2 = new DefaultListModel<String>();
	
	static public VistaAltaLista getInstancia() {
		if (instancia == null) {
			instancia = new VistaAltaLista();
		}
		return instancia;
	}
	
	public VistaAdminAltaParticipantes(){
		
		setSize(450,300);
		setTitle("Agregar participantes");
		frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setType(Type.UTILITY);
		setResizable(false);
			
		JList<String> listUsuarios = new JList<String>();
		listUsuarios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listUsuarios.setBounds(109, 54, 84, 141);
		contentPane.add(listUsuarios);
		
		JList<String> listParticipantes = new JList<String>();
		listParticipantes.setBounds(325, 54, 84, 141);
		contentPane.add(listParticipantes);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(176, 242, 255, 18);
		contentPane.add(labelResultado);
		
		/*Lista todos los usuarios activos*/
		JButton btnListarUsuarios = new JButton("Listar");
		btnListarUsuarios.setBounds(10, 51, 89, 23);
		contentPane.add(btnListarUsuarios);
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel<String> dml = new DefaultListModel<String>();
				ArrayList<Usuario> aux = UsuarioController.getInstancia().buscarUsuariosActivos(); 
				for (int i = 0; i<aux.size(); i++){
					dml.addElement(aux.get(i).getNombreDeUsuario());
				}
				listUsuarios.setModel(dml);
			}
		});
		
		JButton btnQuitarParticipante = new JButton("Quitar");
		btnQuitarParticipante.setBounds(213, 119, 89, 23);
		contentPane.add(btnQuitarParticipante);
		btnQuitarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel<String> model = (DefaultListModel<String>) listParticipantes.getModel();
				int selectedIndex = listParticipantes.getSelectedIndex();
				if (selectedIndex != -1) {
				    model.remove(selectedIndex);
				}		
			}	
		});
		
		//Terminar
		JButton btnAgregarParticipante = new JButton("Agregar");
		btnAgregarParticipante.setBounds(213, 85, 89, 23);
		contentPane.add(btnAgregarParticipante);
		btnAgregarParticipante.addActionListener(new ActionListener() {
			//
			public void actionPerformed(ActionEvent arg0) {
				String seleccionado = (String) listUsuarios.getSelectedValue();
				int indice = listUsuarios.getSelectedIndex();
				dml2.addElement(seleccionado); 
				listParticipantes.setModel(dml2);		
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(342, 11, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lista = ListaController.getInstancia().buscarLista(textFieldNombreLista.getText());
				if (lista == null){
					labelResultado.setText("No existe una lista con ese nombre");
				}else{
					btnBuscar.setEnabled(false);
					textFieldNombreLista.setEnabled(false);
					labelResultado.setText("Lista: " + lista.getNombreLista());
				}
			}	
		});
		
		textFieldNombreLista = new JTextField();
		textFieldNombreLista.setBounds(109, 12, 192, 20);
		contentPane.add(textFieldNombreLista);
		textFieldNombreLista.setColumns(10);
		
		JLabel lblNombreDeLista = new JLabel("Nombre de lista:");
		lblNombreDeLista.setBounds(10, 15, 89, 14);
		contentPane.add(lblNombreDeLista);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 237, 89, 23);
		contentPane.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  for (int i = 0; i < listParticipantes.getModel().getSize(); i++)
			              lista.agregarParticipante((Participante)UsuarioController.getInstancia().buscarUsuario(String.valueOf(listParticipantes.getModel().getElementAt(i))));
          		  labelResultado.setText("Participantes agregados a la lista");
			}	
		});		
	}
}
