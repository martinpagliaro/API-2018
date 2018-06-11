package modelo;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import controlador.UsuarioView;
import persistencia.AdmPersistenciaUsuario;

public abstract class Usuario {
	protected String nombreDeUsuario;
	protected int idUsuario;
	//protected String nombre;
	//protected LocalDateTime fechaNac;
	//protected String mail;
	protected String password;
	//protected int idRole;
	protected boolean estadoUsuario; /*Estado del usuario (Activo/Desactivado)*/
	protected Date ultimaModificacion; /*la ultima modificación no se persiste*/
	protected Date fechaCreacion;
	protected boolean admin; //1: Admin / 0: Usuario (Participante)
	
	/*Contructor para la BD*/	
	public Usuario(String nombreDeUsuario, String password, Date fechaCreacion, boolean estadoUsuario) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.password = password;
		this.estadoUsuario = estadoUsuario;
		this.ultimaModificacion = Calendar.getInstance().getTime();
		this.fechaCreacion = fechaCreacion;
	}
	
	/*Constructor de un usuario nuevo*/
	public Usuario(String nombreDeUsuario, String passwordString) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.password = passwordString;
		this.estadoUsuario = true;
		this.ultimaModificacion = Calendar.getInstance().getTime();
		this.fechaCreacion = Calendar.getInstance().getTime();
	}
	
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	public boolean getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
		
	public String getPassword(){
		return password;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public boolean passwordCorrecta(String passwordString) {
		return (this.password.equals(passwordString));
	}
	
	
	
	/*
	public boolean passwordCorrecta (String password) {
		return this.password.passwordCorrecta(password);
	}
	
	public boolean passwordVencida () {
		return this.password.estaVencida();
	}

	public void cambiarPassword(String password) {
		this.password.setPasswordString(password);
	}
	
	public static String setCaducidadPass() {
		return Password.setCaducidad();
	}

	public static int setCaducidadPass(String caducidad) {
		return Password.setCaducidad(caducidad);
	}
	*/
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean esUsuario(String nombreDeUsuario){
		return this.nombreDeUsuario.equals(nombreDeUsuario);
	}
	
	public abstract UsuarioView getUsuarioView();
	
	static public int updateUsuarioDB(Usuario u) {
		return AdmPersistenciaUsuario.getInstancia().updateUsuario(u);
	}
	
	static public Usuario buscarUsuarioDB(String nombreDeUsuario) {
		return AdmPersistenciaUsuario.getInstancia().buscarUsuario(nombreDeUsuario);
	}
	
}
