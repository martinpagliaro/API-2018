package vista;

import javax.swing.JFrame;

import controlador.UsuarioController;

public class Main extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6001503208821565053L;

	public static void main(String[] args) 
	{
		Main inst = new Main();
		inst.setVisible(true);
	}
	
	public Main()
	{
		initGUI();
	}
	
	private void initGUI()
	{
		try
		{
			//UsuarioController.getInstancia().cargarExpiracionPass();
			VistaLogin.getInstancia().setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
