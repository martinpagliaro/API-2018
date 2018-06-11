package vista;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ListaController;
import controlador.ListaView;

public class VistaModificarLista extends JFrame{
	
private static final long serialVersionUID = -228100595448307234L;
	
	private JPanel contentPane;
	private String nombreLista;

	/**
	 * Create the frame.
	 */
	public VistaModificarLista() {
		setTitle("Modificar Lista");
		setResizable(false);
		setBounds(100, 100, 456, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListaView lv = ListaController.getInstancia().mostrarLista(nombreLista);
		
		
		JLabel lblNombreLista = new JLabel("Nombre lista");
		lblNombreLista.setBounds(10, 11, 83, 14);
		contentPane.add(lblNombreLista);
		
		JLabel lblNombreAgasajado = new JLabel("Nombre agasajado");
		lblNombreAgasajado.setBounds(10, 36, 95, 14);
		contentPane.add(lblNombreAgasajado);
		
		JLabel lblFechaNacAgasajado = new JLabel("Fecha de naci del agasajado");
		lblFechaNacAgasajado.setBounds(10, 61, 146, 14);
		contentPane.add(lblFechaNacAgasajado);
		
		JLabel lblmailAgasajado = new JLabel("Mail agas.");
		lblmailAgasajado.setBounds(10, 86, 83, 14);
		contentPane.add(lblmailAgasajado);
		
		JLabel lblMontoTotal = new JLabel("Monto total");
		lblMontoTotal.setBounds(10, 111, 83, 14);
		contentPane.add(lblMontoTotal);
		
		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setBounds(10, 136, 83, 14);
		contentPane.add(lblFechaFin);
		
		TextField textNombreLista = new TextField();
		textNombreLista.setBounds(158, 3, 247, 22);
		contentPane.add(textNombreLista);
		
		TextField textNombreAgasajado = new TextField();
		textNombreAgasajado.setBounds(158, 28, 247, 22);
		contentPane.add(textNombreAgasajado);
		
		TextField textFechaNacAgasajado = new TextField();
		textFechaNacAgasajado.setBounds(158, 53, 247, 22);
		contentPane.add(textFechaNacAgasajado);
		
		TextField textMailAgasajado = new TextField();
		textMailAgasajado.setBounds(158, 78, 247, 22);
		contentPane.add(textMailAgasajado);
		
		TextField textMontoTotal = new TextField();
		textMontoTotal.setBounds(158, 103, 247, 22);
		contentPane.add(textMontoTotal);
		
		TextField textFechaFin = new TextField();
		textFechaFin.setBounds(158, 128, 247, 22);
		contentPane.add(textFechaFin);
		
		if (lv != null) {
			textNombreLista.setText(lv.getNombreLista());
			textNombreAgasajado.setText(lv.getNombreAgasajado());
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
			String aux = format.format(lv.getFechaNacAgasajado());
			textFechaNacAgasajado.setText(aux);
			textMailAgasajado.setText(lv.getMailAgasajado());
			textMontoTotal.setText(String.valueOf(lv.getMontoTotal()));
			String aux2 = format.format(lv.getFechaFin());
			textFechaFin.setText(aux2);
		}
		else {

		}
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setBounds(73, 189, 332, 22);
		contentPane.add(lblMensaje);
		
		JButton btnConfirmarCambios = new JButton("Confirmar cambios");
		btnConfirmarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (! textNombreLista.getText().isEmpty() & ! textNombreAgasajado.getText().isEmpty() & ! textFechaNacAgasajado.getText().isEmpty() 
						& ! textMailAgasajado.getText().isEmpty() & ! textMontoTotal.getText().isEmpty() & ! textFechaFin.getText().isEmpty()) {
					int resPassRst = -1;
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
					int resModificar;
					try {
						resModificar = ListaController.getInstancia().modificarLista(textNombreLista.getText(), textNombreAgasajado.getText(), textMailAgasajado.getText(), format.parse(textFechaNacAgasajado.getText()), format.parse(textFechaFin.getText()), Float.valueOf(textMontoTotal.getText()));
					if (resModificar == 0 & resPassRst <= 0) {
						lblMensaje.setText("Info modificada.");
					}
					else if(resModificar > 0 & resPassRst == -1) {
						lblMensaje.setText("No pudo modificarse la informacion");
					}
				
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else {
					lblMensaje.setText("Todos los campos deben estar completos.");
				}
			}
		});
		btnConfirmarCambios.setBounds(10, 161, 171, 23);
		contentPane.add(btnConfirmarCambios);
		
	}

}
