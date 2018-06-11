package vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
import controlador.ListaController;
import controlador.UsuarioController;
import modelo.Participante;
import modelo.Usuario;

import javax.swing.DefaultListModel;

public class VistaAltaLista extends JFrame {
	
private static final long serialVersionUID = -3173593118178927673L;
	
	private JPanel contentPane;
	private JTextField textNombreLista;
	private JTextField textNombreAgasajado;
	private JTextField textFechaNacAgasajado;
	private JTextField textMailAgasajado;
	private JTextField textMontoTotal;
	private JTextField textFechaInicio;
	private JTextField textFechaFin;
	//private ArrayList<String> usuarios;
	//private ArrayList<String> participantes;
	static private VistaAltaLista instancia;
	
	
	//test
	public static void main(String[] args) 
	{
		VistaAltaLista inst = new VistaAltaLista();
		inst.setVisible(true);
	}
	
	public VistaAltaLista()
	{
		initGUI();
	}
	//
	

	
	static public VistaAltaLista getInstancia() {
		if (instancia == null) {
			instancia = new VistaAltaLista();
		}
		return instancia;
	}
	
	
	//Cambiar el nombre de nuevo a VistaAltaLista y sacar el void
	public void initGUI() {
		
		//usuarios.add("Martin");
		//usuarios.add("Lucas");
		
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Crear Lista");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreLista = new JLabel("Nombre de lista");
		lblNombreLista.setBounds(10, 11, 84, 14);
		contentPane.add(lblNombreLista);
		
		JLabel lblNOmbreAgasajado = new JLabel("Nombre del agasajado");
		lblNOmbreAgasajado.setBounds(10, 36, 114, 14);
		contentPane.add(lblNOmbreAgasajado);
		
		JLabel lblFechaNacAgasajado = new JLabel("Fecha de nac. del agasajado");
		lblFechaNacAgasajado.setBounds(10, 61, 148, 14);
		contentPane.add(lblFechaNacAgasajado);
		
		JLabel lblMailAgasajado = new JLabel("Mail agasajado");
		lblMailAgasajado.setBounds(10, 86, 65, 14);
		contentPane.add(lblMailAgasajado);
		
		JLabel lblMontoTotal = new JLabel("Monto Total");
		lblMontoTotal.setBounds(10, 111, 65, 14);
		contentPane.add(lblMontoTotal);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setBounds(10, 136, 65, 14);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setBounds(10, 161, 65, 14);
		contentPane.add(lblFechaFin);
		
		JLabel lblParticipantes = new JLabel("Participantes");
		lblParticipantes.setBounds(10, 186, 65, 14);
		contentPane.add(lblParticipantes);
		
		JList listUsuarios = new JList();
		listUsuarios.setBounds(154, 185, 84, 141);
		contentPane.add(listUsuarios);
		
		JList listParticipantes = new JList();
		listParticipantes.setBounds(347, 185, 84, 141);
		contentPane.add(listParticipantes);
		
		textNombreLista = new JTextField();
		textNombreLista.setBounds(154, 8, 250, 20);
		contentPane.add(textNombreLista);
		textNombreLista.setColumns(10);
		
		textNombreAgasajado = new JTextField();
		textNombreAgasajado.setBounds(154, 33, 250, 20);
		contentPane.add(textNombreAgasajado);
		textNombreAgasajado.setColumns(10);
		
		textFechaNacAgasajado = new JTextField();
		textFechaNacAgasajado.setBounds(154, 58, 250, 20);
		contentPane.add(textFechaNacAgasajado);
		textFechaNacAgasajado.setColumns(10);
		
		textMailAgasajado = new JTextField();
		textMailAgasajado.setBounds(154, 83, 250, 20);
		contentPane.add(textMailAgasajado);
		textMailAgasajado.setColumns(10);
		
		textMontoTotal = new JTextField();
		textMontoTotal.setBounds(154, 108, 250, 20);
		contentPane.add(textMontoTotal);
		textMontoTotal.setColumns(10);
		
		textFechaInicio = new JTextField();
		textFechaInicio.setBounds(154, 133, 250, 20);
		contentPane.add(textFechaInicio);
		textFechaInicio.setColumns(10);
		
		textFechaFin = new JTextField();
		textFechaFin.setBounds(154, 158, 250, 20);
		contentPane.add(textFechaFin);
		textFechaFin.setColumns(10);
		
		JLabel labelResultado = new JLabel("");
		labelResultado.setBounds(10, 170, 161, 18);
		contentPane.add(labelResultado);
		
		JButton btnCrearLista = new JButton("Crear Lista");
		btnCrearLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
				String nombreLista = textNombreLista.getText();
				String nombreAgasajado = textNombreAgasajado.getText();
				Date fechaNacAgasajado = null;
				Date fechaFin = null;
				Date fechaInicio = null;
				try {
					fechaNacAgasajado = format.parse(textFechaNacAgasajado.getText());
					fechaInicio = format.parse(textFechaInicio.getText());
					fechaFin = format.parse(textFechaFin.getText());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String mailAgasajado = textMailAgasajado.getText();
				float montoTotal = Float.parseFloat(textMontoTotal.getText());
				String estadoLista = "Iniciada";
				float montoPorParticipante = 0;
				float montoRecaudado = 0;
				Usuario administrador = UsuarioController.getInstancia().getUsuarioLogueado();
				ArrayList<Participante> participantes = new ArrayList<Participante>(); 
				int error = ListaController.getInstancia().altaLista(administrador, nombreLista, nombreAgasajado, fechaNacAgasajado, mailAgasajado, participantes, montoTotal, montoPorParticipante, montoRecaudado, fechaInicio, fechaFin, estadoLista);
				switch (error) {
					case 0:
						VistaAltaLista.getInstancia().setVisible(false);
						break;
					case 1:
						labelResultado.setText("El nombre de la lista ya existe.");
						textNombreLista.selectAll();
						break;
				}
			}
		});
		btnCrearLista.setBounds(10, 337, 161, 23);
		contentPane.add(btnCrearLista);

		/*Lista todos los usuarios activos*/
		JButton btnListarUsuarios = new JButton("Listar");
		btnListarUsuarios.setBounds(10, 211, 89, 23);
		contentPane.add(btnListarUsuarios);
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel dml = new DefaultListModel();
				ArrayList<Usuario> aux = UsuarioController.getInstancia().buscarUsuariosActivos(); 
				for (int i = 0; i<aux.size(); i++){
					dml.addElement(aux.get(i).getNombreDeUsuario());
				}
				listUsuarios.setModel(dml);
			}
		});
		
		JButton btnQuitarParticipante = new JButton("Quitar");
		btnQuitarParticipante.setBounds(248, 249, 89, 23);
		contentPane.add(btnQuitarParticipante);
		btnQuitarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel model = (DefaultListModel) listParticipantes.getModel();
				int selectedIndex = listParticipantes.getSelectedIndex();
				if (selectedIndex != -1) {
				    model.remove(selectedIndex);
				}		
			}	
		});
		
		//Terminar
		JButton btnAgregarParticipante = new JButton("Agregar");
		btnAgregarParticipante.setBounds(248, 211, 89, 23);
		contentPane.add(btnAgregarParticipante);
		btnAgregarParticipante.addActionListener(new ActionListener() {
			DefaultListModel dml2 = new DefaultListModel();
			public void actionPerformed(ActionEvent arg0) {
				String seleccionado = (String) listUsuarios.getSelectedValue();
				int indice = listUsuarios.getSelectedIndex();
				dml2.addElement(seleccionado); 
				listParticipantes.setModel(dml2);		
			}
		});
		
	
		

	}
}
