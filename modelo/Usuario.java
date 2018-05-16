package modelo;

import java.sql.Date;

public abstract class Usuario {
	protected int idUsuario;
	protected String nombre;
	protected Date fechaNac;
	protected String mail;
	protected Password password;
	protected int idRole;
	protected boolean estadoUsuario; /*Estado del usuario*/
		
	public Usuario(int idUsuario, String nombre, Date fechaNac, String mail, Password password, int idRole,
			boolean estadoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.mail = mail;
		this.password = password;
		this.idRole = idRole;
		this.estadoUsuario = estadoUsuario;
	}

	public boolean getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
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
	
	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public boolean esUsuario(int idUsuario){
		return this.idUsuario == idUsuario;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
