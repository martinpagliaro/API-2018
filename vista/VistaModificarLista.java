package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.ListaController;
import controlador.ListaView;

public class VistaModificarLista extends JFrame{

	private static final long serialVersionUID = -2921602399012011283L;
	private JLabel labelNombreLista;
	private JLabel labelNombreAgasajado;
	private JLabel labelFechaNacAgasajado;
	private JLabel labelMailAgasajado;
	private JLabel labelMontoTotal;
	private JLabel labelFechaFin;
	private JTextField textFieldNombreLista;
	private JTextField textFieldNombreAgasajado;
	private JTextField textFieldFechaNacAgasajado;
	private JTextField textFieldMaiAgasajado;
	private JTextField textFieldMontoTotal;
	private JTextField textFieldFechaFin;
	private JButton botonBuscar;
	private JButton botonModificar;
	private ListaView lv;

	public VistaModificarLista()
	{
		crearPantalla();
	}

	private void crearPantalla()
	{
		try
		{
			setTitle("Modificar Lista");
			setSize(402, 315);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			labelNombreLista = new JLabel();
			getContentPane().add(labelNombreLista);
			labelNombreLista.setText("Nombre de lista:");
			labelNombreLista.setBounds(7, 11, 103, 28);

			textFieldNombreLista = new JTextField();
			textFieldNombreLista.setBounds(120, 15, 143, 20);
			getContentPane().add(textFieldNombreLista);
			textFieldNombreLista.setColumns(10);
			
			botonBuscar = new JButton("buscar");
			getContentPane().add(botonBuscar);
			botonBuscar.setBounds(273, 14, 103, 22);
			botonBuscar.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					lv = ListaController.getInstancia().mostrarLista(textFieldNombreLista.getText());
					if (lv != null)
					{
						textFieldNombreLista.setEnabled(false);
						botonBuscar.setEnabled(false);
						
						labelNombreAgasajado.setVisible(true);
						labelFechaNacAgasajado.setVisible(true);
						labelMailAgasajado.setVisible(true);
						labelMontoTotal.setVisible(true);
						labelFechaFin.setVisible(true);
						
						botonModificar.setVisible(true);
						botonModificar.setEnabled(true);
						
						textFieldNombreAgasajado.setVisible(true);
						textFieldNombreAgasajado.setEnabled(true);
						textFieldNombreAgasajado.setText(lv.getNombreAgasajado());
						
						textFieldFechaNacAgasajado.setVisible(true);
						textFieldFechaNacAgasajado.setEnabled(true);
						SimpleDateFormat dateFormatter; 
						dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
						textFieldFechaNacAgasajado.setText(dateFormatter.format (lv.getFechaNacAgasajado()));
						
						textFieldMaiAgasajado.setVisible(true);
						textFieldMaiAgasajado.setEnabled(true);
						textFieldMaiAgasajado.setText(lv.getMailAgasajado());
						
						textFieldMontoTotal.setVisible(true);
						textFieldMontoTotal.setEnabled(true);
						textFieldMontoTotal.setText(String.valueOf(lv.getMontoTotal()));
						
						textFieldFechaFin.setVisible(true);
						textFieldFechaFin.setEnabled(true);
						textFieldFechaFin.setText(dateFormatter.format (lv.getFechaFin()));
						
					}else
					{
						JOptionPane.showMessageDialog((Component)e.getSource(), "Lista inexistente");
					}
				}

			});

			labelNombreAgasajado = new JLabel("Nombre agasajado:");
			labelNombreAgasajado.setBounds(7, 68, 100, 14);
			getContentPane().add(labelNombreAgasajado);
			labelNombreAgasajado.setVisible(true);
		
			labelFechaNacAgasajado = new JLabel("F. nac. agasajado:");
			labelFechaNacAgasajado.setBounds(10, 100, 114, 14);
			getContentPane().add(labelFechaNacAgasajado);
			labelFechaNacAgasajado.setVisible(true);

			labelMailAgasajado = new JLabel("E-Mail agasajado:");
			labelMailAgasajado.setBounds(10, 135, 103, 14);
			getContentPane().add(labelMailAgasajado);
			labelMailAgasajado.setVisible(true);
			
			labelMontoTotal = new JLabel("Monto:");
			labelMontoTotal.setBounds(10, 168, 83, 14);
			getContentPane().add(labelMontoTotal);
			labelMontoTotal.setVisible(true);
			
			labelFechaFin = new JLabel("Fecha fin:");
			labelFechaFin.setBounds(10, 197, 83, 14);
			getContentPane().add(labelFechaFin);
			labelFechaFin.setVisible(true);

			textFieldNombreAgasajado = new JTextField();
			textFieldNombreAgasajado.setVisible(true);
			textFieldNombreAgasajado.setEnabled(false);
			textFieldNombreAgasajado.setBounds(117, 64, 247, 22);
			getContentPane().add(textFieldNombreAgasajado);
			
			textFieldFechaNacAgasajado = new JTextField();
			textFieldFechaNacAgasajado.setBounds(117, 96, 247, 22);
			textFieldFechaNacAgasajado.setVisible(true);
			textFieldFechaNacAgasajado.setEnabled(false);
			getContentPane().add(textFieldFechaNacAgasajado);
			
			textFieldMaiAgasajado = new JTextField();
			textFieldMaiAgasajado.setBounds(117, 125, 247, 22);
			textFieldMaiAgasajado.setVisible(true);
			textFieldMaiAgasajado.setEnabled(false);
			getContentPane().add(textFieldMaiAgasajado);
			
			textFieldMontoTotal = new JTextField();
			textFieldMontoTotal.setBounds(117, 156, 247, 22);
			textFieldMontoTotal.setVisible(true);
			textFieldMontoTotal.setEnabled(false);
			getContentPane().add(textFieldMontoTotal);
			
			textFieldFechaFin = new JTextField();
			textFieldFechaFin.setBounds(117, 189, 247, 22);
			textFieldFechaFin.setVisible(true);
			textFieldFechaFin.setEnabled(false);
			getContentPane().add(textFieldFechaFin);

			botonModificar = new JButton("Modificar");
			botonModificar.setBounds(24, 242, 89, 23);
			getContentPane().add(botonModificar);
			botonModificar.setVisible(true);
			botonModificar.setEnabled(false);
			botonModificar.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
					Date fechaNacAgasajado;
					Date fechaFin;
					try {
						fechaNacAgasajado = format.parse(textFieldFechaNacAgasajado.getText());
						fechaFin = format.parse(textFieldFechaFin.getText());
						ListaController.getInstancia().modificarLista(textFieldNombreLista.getText(), textFieldNombreAgasajado.getText(), textFieldMaiAgasajado.getText(), fechaNacAgasajado, fechaFin, Float.valueOf(textFieldMontoTotal.getText()));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog((Component)e.getSource(), "Lista modificada");
					
					textFieldNombreLista.setText("");
					textFieldNombreLista.setEnabled(true);
					
					textFieldNombreAgasajado.setText("");
					textFieldNombreAgasajado.setEnabled(false);
					
					textFieldFechaNacAgasajado.setText("");
					textFieldFechaNacAgasajado.setEnabled(false);
					
					textFieldMaiAgasajado.setText("");
					textFieldMaiAgasajado.setEnabled(false);
					
					textFieldMontoTotal.setText("");
					textFieldMontoTotal.setEnabled(false);
					
					textFieldFechaFin.setText("");
					textFieldFechaFin.setEnabled(false);
					
					botonBuscar.setEnabled(true);
					botonModificar.setEnabled(false);
				}

			});

			JButton botonCerrar = new JButton();
			getContentPane().add(botonCerrar);
			botonCerrar.setText("Cerrar");
			botonCerrar.setBounds(299, 239, 77, 28);
			botonCerrar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					dispose();

				}

			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
