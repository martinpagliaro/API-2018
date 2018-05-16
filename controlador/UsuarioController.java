package controlador;

import java.sql.Date;
import java.util.ArrayList;

import modelo.Administrador;
import modelo.Participante;
import modelo.Password;
import modelo.Usuario;

public class UsuarioController {
	
	private ArrayList<Usuario> usuarios;
	private static UsuarioController instancia;
	
	static public UsuarioController getInstancia() {
		if(UsuarioController.instancia == null) {
			UsuarioController.instancia = new UsuarioController();
		}
		return UsuarioController.instancia;
	}
	
	private Usuario buscarUsuario (int idUsuario){
		for (int i=0;i<usuarios.size();i++){
			Usuario usr = usuarios.get(i);
			if (usr.esUsuario(idUsuario))
				return usr;
		}
		return null;
	}
	
	/*Alta de usuario administrador*/
	public void altaAdministrador (int idUsuario, String nombre, Date fechaNac, String mail, Password password, int idRole, 
			boolean estadoUsuario){
		Administrador adm = new Administrador (idUsuario, nombre, fechaNac, mail, password, idRole, estadoUsuario);
		usuarios.add(adm);
	}
	
	/*Alta de usuario participante*/
	public void altaParticipante (int idUsuario, String nombre, Date fechaNac, String mail, Password password, int idRole, 
			boolean estadoUsuario, boolean pagado, float montoPago){
		Participante part = new Participante (idUsuario, nombre, fechaNac, mail, password, idRole,
				estadoUsuario, pagado, montoPago);
		usuarios.add(part);
	}
	
	/*Modificacion de usuario (Administrador y participante)*/
	public void modificarUsuario(int idUsuario, String nombre, String mail, Date fechaNac){
		Usuario usr = buscarUsuario(idUsuario);
		if (usr!=null){
			usr.setNombre(nombre);
			usr.setMail(mail);
			usr.setFechaNac(fechaNac);
		}
	}
	
	/*Baja de usuario (Administrador y participante)*/
	public boolean bajaUsuario(int idUsuario){
		Usuario usr = buscarUsuario(idUsuario);
		if (usr!=null){
			usuarios.remove(usr);						
			return true;
		}
		return false;	
	}

}
