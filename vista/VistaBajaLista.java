package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controlador.ListaController;

public class VistaBajaLista extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel labelNombre;
	private JLabel labelInstruccion;
	private JTextField textFieldNombre;
	private JButton botonBaja;
	private JButton botonCerrar;
	
		
	public VistaBajaLista()
	{
		crearPantalla();
	}
	
	private void crearPantalla()
	{
		try
		{
			setSize(400, 270);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			labelNombre = new JLabel();
			getContentPane().add(labelNombre);
			labelNombre.setText("Lista:");
			labelNombre.setBounds(25, 94, 63, 28);
			
			labelInstruccion = new JLabel("Ingrese el nombre de la lista a eliminar");
			labelInstruccion.setBounds(106, 52, 292, 14);
			getContentPane().add(labelInstruccion);
						
			textFieldNombre = new JTextField();
			getContentPane().add(textFieldNombre);
			textFieldNombre.setBounds(119, 94, 147, 28);
			
			botonBaja = new JButton();
			getContentPane().add(botonBaja);
			botonBaja.setText("Baja");
			botonBaja.setBounds(156, 133, 77, 28);
			botonBaja.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					boolean resultado = ListaController.getInstancia().bajaLista(textFieldNombre.getText());
					textFieldNombre.setText("");
					
					if (resultado)
					{
						JOptionPane.showMessageDialog((Component)evt.getSource(), "Lista eliminada"); 
					}
					else
					{
						JOptionPane.showMessageDialog((Component)evt.getSource(), "La lista no existe"); 
					}
				}
			});
			
			botonCerrar = new JButton();
			getContentPane().add(botonCerrar);
			botonCerrar.setText("Cerrar");
			botonCerrar.setBounds(156, 185, 77, 28);
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
