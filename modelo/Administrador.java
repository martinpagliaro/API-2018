package modelo;

import controlador.UsuarioView;
import persistencia.AdmPersistenciaUsuario;

public class Administrador extends Usuario{
	
	public Administrador(String nombreDeUsuario, String passwordString) {
		super(nombreDeUsuario, passwordString);
		//AdmPersistenciaUsuario.getInstancia().insertUsuario(this);
	}

	public UsuarioView getUsuarioView() {
		return (new UsuarioView(this.nombreDeUsuario, this.estadoUsuario));
	}

	public String getNombre() {
		return nombreDeUsuario;
	}
	
}
