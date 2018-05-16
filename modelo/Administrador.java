package modelo;

import java.sql.Date;

public class Administrador extends Usuario{

	public Administrador(int idUsuario, String nombre, Date fechaNac, String mail, Password password, int idRole,
			boolean estadoUsuario) {
		super(idUsuario, nombre, fechaNac, mail, password, idRole, estadoUsuario);
	}

}

