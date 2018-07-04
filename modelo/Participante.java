package modelo;


import java.util.Date;

import controlador.UsuarioView;

public class Participante extends Usuario{
	private String nombre;
	private String mail;
	private Date fechaNac;
	private boolean pagado;
	private float montoPago;
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public float getMontoPago() {
		return montoPago;
	}

	public void setMontoPago(float montoPago) {
		this.montoPago = montoPago;
	}

	public UsuarioView getUsuarioView() {
		return (new UsuarioView(this.nombre, this.fechaNac, this.mail, this.nombreDeUsuario,this.estadoUsuario));
	}
	
	public Participante(String nombreDeUsuario, String nombre, Date fechaNac,
			String mail, String passwordString) {
		super(nombreDeUsuario, passwordString);
		this.nombre = nombre;
		this.mail = mail;
		this.fechaNac = fechaNac;
		//AdmPersistenciaUsuario.getInstancia().insertUsuario(this);
	}
	
	public Participante(String nombreDeUsuario, String password, Date fechaCreacion, boolean estadoUsuario,
			String nombre, String mail, Date fechaNac, boolean pagado, float montoPago) {
		super(nombreDeUsuario, password, fechaCreacion, estadoUsuario);
		this.nombre = nombre;
		this.mail = mail;
		this.fechaNac = fechaNac;
		this.pagado = pagado;
		this.montoPago = montoPago;
	}

	public UsuarioView crearVista() {
		UsuarioView uv = new UsuarioView(nombre, fechaNac, mail, nombreDeUsuario, estadoUsuario);
		return uv;
	}
	
	public boolean esParticipante (String nombreDeUsuario){
		return this.nombreDeUsuario.equals(nombreDeUsuario);
	}
	
	public boolean crearPago(String nombreLista, String nombreUsuario, Date fecha, float monto) {
		return AdmPersistenciaLista.getInstancia().CrearNuevoPago(nombreLista,nombreUsuario,fecha,monto);
	}
	
}
