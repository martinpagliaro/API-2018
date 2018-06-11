package vista;

import java.awt.Component;
import java.awt.TextField;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controlador.UsuarioController;
import controlador.UsuarioView;
import modelo.Usuario;

public class VistaModificarUsuario extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2921602399012011283L;
	private JPanel contentPane;
	private JLabel labelUsuario; 
	private JTextField textFieldUsuario;
	private JButton botonBuscar;
	private UsuarioView uv;
	private JButton botonModificar;
	private JLabel lblNombre;
	private JLabel lblFechaNac;
	private JLabel lbllblEmail;
	private JTextField textNombre;
	private JTextField textFechaNac;
	private JTextField textMail;
	
	public VistaModificarUsuario()
	{
		crearPantalla();
	}
		
	private void crearPantalla()
	{
		try
		{
			setTitle("Modificar Usuario");
			setSize(400, 250);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			getContentPane().setLayout(null);
			
			labelUsuario = new JLabel();
			getContentPane().add(labelUsuario);
			labelUsuario.setText("Usuario:");
			labelUsuario.setBounds(10, 61, 63, 28);
			
			textFieldUsuario = new JTextField();
			textFieldUsuario.setBounds(83, 15, 140, 20);
			getContentPane().add(textFieldUsuario);
			textFieldUsuario.setColumns(10);
			
			botonBuscar = new JButton("buscar");
			getContentPane().add(botonBuscar);
			botonBuscar.setBounds(243, 14, 103, 22);
			
			botonBuscar.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					uv = UsuarioController.getInstancia().getLoggedUserView();
					
					if (uv != null)
					{
						textFieldUsuario.setEnabled(false);
						botonBuscar.setEnabled(false);
						
						lblNombre.setVisible(true);
						lblFechaNac.setVisible(true);
						lbllblEmail.setVisible(true);
						botonModificar.setVisible(true);
						botonModificar.setEnabled(true);
						
						textNombre.setVisible(true);
						textNombre.setEnabled(true);
						textNombre.setText(uv.getNombre());
						
						textFechaNac.setVisible(true);
						textFechaNac.setEnabled(true);
						SimpleDateFormat dateFormatter; 
						dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ROOT);
						textFechaNac.setText(dateFormatter.format(uv.getFechaNac()));
						
						textMail.setVisible(true);
						textMail.setEnabled(true);
						textMail.setText(uv.getNombre());
						
					}else
					{
						JOptionPane.showMessageDialog((Component)e.getSource(), "Usuario inexistente");
					}
					
				}
			});
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 18, 63, 14);
			contentPane.add(lblNombre);
			lblNombre.setVisible(true);
			
			JLabel lblFechaNac = new JLabel("F. Nac:");
			lblFechaNac.setBounds(10, 100, 83, 14);
			contentPane.add(lblFechaNac);
			lblFechaNac.setVisible(true);
			
			JLabel lblEmail = new JLabel("E-Mail:");
			lblEmail.setBounds(10, 132, 83, 14);
			contentPane.add(lblEmail);
			lblEmail.setVisible(true);
			
			TextField textNombre = new TextField();
			textNombre.setVisible(true);
			textNombre.setEnabled(false);
			textNombre.setBounds(83, 61, 140, 22);
			contentPane.add(textNombre);
			
			TextField textFechaNac = new TextField();
			textFechaNac.setBounds(83, 92, 140, 22);
			textFechaNac.setVisible(true);
			textFechaNac.setEnabled(false);
			contentPane.add(textFechaNac);
			
			TextField textMail = new TextField();
			textMail.setBounds(83, 124, 247, 22);
			textMail.setVisible(true);
			textMail.setEnabled(false);
			contentPane.add(textMail);
			
			botonModificar = new JButton("Modificar");
			botonModificar.setBounds(10, 175, 89, 23);
			getContentPane().add(botonModificar);
			botonModificar.setVisible(true);
			botonModificar.setEnabled(false);
			botonModificar.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ROOT);
					Date fechaNac;
					try {
						fechaNac = format.parse(textFechaNac.getText());
						UsuarioController.getInstancia().modificarLoggedUser(textNombre.getText(), textMail.getText(), fechaNac);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					JOptionPane.showMessageDialog((Component)e.getSource(), "Usuario modificado");
					
					textFieldUsuario.setText("");
					textFieldUsuario.setEnabled(true);
					
					textNombre.setText("");
					textNombre.setEnabled(false);
					
					textFechaNac.setText("");
					textFechaNac.setEnabled(false);
					
					textMail.setText("");
					textMail.setEnabled(false);
					
					botonBuscar.setEnabled(true);
					botonModificar.setEnabled(false);
				}
			});
			
			JButton botonCerrar = new JButton();
			getContentPane().add(botonCerrar);
			botonCerrar.setText("Cerrar");
			botonCerrar.setBounds(297, 172, 77, 28);
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
