package controlador;

import java.util.Date;
import java.util.ArrayList;

import modelo.Participante;
import modelo.Usuario;

public class ListaView {
	
	private Usuario administrador;
	private String nombreLista;
	private String nombreAgasajado;
	private Date fechaNacAgasajado;
	private String mailAgasajado;
	private ArrayList<Participante> participantes;
	private float montoTotal;
	private Date fechaInicio;
	private Date fechaFin;
	private String estadoLista;
	
	public Usuario getAdministrador() {
		return administrador;
	}
	public String getNombreLista() {
		return nombreLista;
	}
	public String getNombreAgasajado() {
		return nombreAgasajado;
	}
	public Date getFechaNacAgasajado() {
		return fechaNacAgasajado;
	}
	public String getMailAgasajado() {
		return mailAgasajado;
	}
	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}
	public float getMontoTotal() {
		return montoTotal;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public String getEstadoLista() {
		return estadoLista;
	}
	public ListaView(Usuario administrador, String nombreLista, String nombreAgasajado, Date fechaNacAgasajado,
			String mailAgasajado, ArrayList<Participante> participantes, float montoTotal, Date fechaInicio,
			Date fechaFin, String estadoLista) {
		super();
		this.administrador = administrador;
		this.nombreLista = nombreLista;
		this.nombreAgasajado = nombreAgasajado;
		this.fechaNacAgasajado = fechaNacAgasajado;
		this.mailAgasajado = mailAgasajado;
		this.participantes = participantes;
		this.montoTotal = montoTotal;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estadoLista = estadoLista;
	}

}
