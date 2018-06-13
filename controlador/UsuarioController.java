package controlador;

import java.util.Date;
import java.util.ArrayList;

import modelo.Administrador;
import modelo.Participante;
import modelo.Usuario;

public class UsuarioController {
	
	private ArrayList<Usuario> usuarios;
	private static UsuarioController instancia;
	private Usuario usuarioLogueado;
	
	static public UsuarioController getInstancia() {
		if(UsuarioController.instancia == null) {
			UsuarioController.instancia = new UsuarioController();
		}
		return UsuarioController.instancia;
	}
	
	private UsuarioController () {
		usuarios = new ArrayList<Usuario>();
		usuarioLogueado = null;
	}
	
	/*Busca un usuario particular activo*/
	public Usuario buscarUsuario (String nombreDeUsuario){
		for (int i=0;i<usuarios.size();i++){
			Usuario usr = usuarios.get(i);
			if (usr.esUsuario(nombreDeUsuario) && usr.getEstadoUsuario() == true)
				return usr;
		}
		return null;
	}
	
	/*Busca todos los usuarios activos*/
	public ArrayList<Usuario> buscarUsuariosActivos (){
		ArrayList<Usuario> aux = new ArrayList<Usuario>();
		for (int i=0; i<usuarios.size();i++) {
			Usuario usr = usuarios.get(i);
			if (usr.getEstadoUsuario() == true) {
				aux.add(usr);
			}
		}
		return aux;
	}
	
	/*Alta de usuario administrador*/
	public int altaAdministrador (String nombreDeUsuario, String password){
		if (buscarUsuario(nombreDeUsuario)==null) {
			Administrador adm = new Administrador (nombreDeUsuario, password);
			usuarios.add(adm);
			return 0; //Usuario creado
		}
		return 1; //Usuario ya existe
	}
	
	/*Alta de usuario participante*/
	public int altaParticipante (String nombreDeUsuario, String nombre, Date fechaNac, String mail, String passwordString){
		if (buscarUsuario(nombreDeUsuario) == null) {
			Participante part = new Participante (nombreDeUsuario, nombre, fechaNac, mail, passwordString);
			usuarios.add(part);
			return 0; //Usuario creado
		}
		return 1; //Usuario ya existe
	}
	
	
	/*Modificacion de usuario (Administrador y participante)*/
	public int modificarUsuario(String nombre, String mail, Date fechaNac){
		if (usuarioLogueado != null) {
			Participante u = (Participante)usuarioLogueado;
			u.setNombre(nombre);
			u.setMail(mail);
			u.setFechaNac(fechaNac);
			Usuario.updateUsuarioDB(usuarioLogueado);
			return 0; //Usuario modificado
		}
		return 1;
	}
	
	/*Baja de usuario (Administrador y participante)*/
	public boolean bajaUsuario(String nombreUsuario){
		Usuario usr = buscarUsuario(nombreUsuario);
		if (usr!=null){
			usuarios.remove(usr);						
			return true;
		}
		return false;	
	}
	
	public int login (String nombreDeUsuario, String passwordString) {
		Usuario usuarioAux = buscarUsuario(nombreDeUsuario);
		if (usuarioAux != null) {
			if (! usuarioAux.getEstadoUsuario()) {
				return 4; //Usuario inactivo.
			}
			/*
			if (! usuarioAux.passwordCorrecta(passwordString)) {
				return 2;  //Password incorrecta.
			}
			if (usuarioAux.passwordVencida()) {
				return 1; //Password vencida. Solicitar cambio.
			}
			*/
			usuarioLogueado = usuarioAux;
			if (usuarioAux instanceof Usuario) {	
				return 0; //Login correcto.
			} else if (usuarioAux instanceof Administrador) {
				return -1; //Login correcto de un Admin!
			}
		}
		return 3; //No existe el usuario
	}
	
	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	/*
	public int cambiarPassword (String passwordString) {
		if (usuarioLogueado != null) {
			usuarioLogueado.cambiarPassword(passwordString);
			return Usuario.updateUsuarioDB(usuarioLogueado); //Cambio correcto.
		}
		return 1; //Fallo el cambio.
	}
	
	
	public int cambiarPassword (String nombreDeUsuario, String passwordString, String nPasswordString) {
		Usuario usuarioAux = buscarUsuario(nombreDeUsuario);
		if (usuarioAux != null) {
			if (usuarioAux.passwordCorrecta(passwordString)) {
				usuarioAux.cambiarPassword(nPasswordString);
				//return Usuario.updateUsuarioDB(usuarioAux); //Cambio correcto.
				return 0; //borrar
			}
		}
		return 1; //Fallo el cambio.
	}
	*/
	
	public UsuarioView getLoggedUserView(){
		if (usuarioLogueado != null) {
			return this.usuarioLogueado.getUsuarioView();
		}
		return null;
	}
	
		
	/*
	public String cargarExpiracionPass() {
		return Usuario.setCaducidadPass();
	}
	
	public int guardarExpiracionPass(String caducidad) {
		return Usuario.setCaducidadPass(caducidad);
	}
	*/
	
	public int modificarLoggedUser(String nombre, String mail, Date fechaNac) {
		if (usuarioLogueado != null) {
			Participante u = (Participante)usuarioLogueado;
			u.setNombre(nombre);
			u.setMail(mail);
			u.setFechaNac(fechaNac);
			Usuario.updateUsuarioDB(usuarioLogueado);
			return 0;
		}
		return 1;
	}
	
		public UsuarioView mostrarUsuario(String nombreDeUsuario){
		Participante p = (Participante) buscarUsuario(nombreDeUsuario);
		if (p != null){	
			return p.crearVista();
		}
		return null;
	}
	
}
