UsuarioView.java

P
Tipo
Java
Tamaño
1 KB (1.050 bytes)
Espacio usado
1 KB (1.050 bytes)
Ubicación
controlador
Propietario
yo
Modificado
8 jun. 2018 por mí
Abierto
16:55 por mí
Creado el
8 jun. 2018 con Google Drive Web
Añadir descripción
Los lectores pueden descargar
package controlador;

import java.util.Date;

public class UsuarioView {
	
	private String nombre;
	private Date fechaNac;
	private String mail;
	private String nombreDeUsuario;
	private boolean estadoUsuario;
	private boolean admin;
		
	public UsuarioView(String nombre, Date fechaNac, String mail,
			String nombreDeUsuario, boolean estadoUsuario) {
		super();
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.mail = mail;
		this.nombreDeUsuario = nombreDeUsuario;
		this.estadoUsuario = estadoUsuario;
		this.admin = false;
	}
	
	public UsuarioView(String nombreDeUsuario, boolean estadoUsuario) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.estadoUsuario = estadoUsuario;
		this.admin = true;
	}
	
	public String getNombre() {
		return nombre;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public String getMail() {
		return mail;
	}
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	public boolean estaActivo() {
		return estadoUsuario;
	}
	public boolean esAdmin() {
		return admin;
	}
			
}
