package modelo;

import java.util.Date;
import java.util.ArrayList;

import controlador.ListaView;

public class Lista {
	private int idLista;
	private Usuario administrador;
	private String nombreLista;
	private String nombreAgasajado;
	private Date fechaNacAgasajado;
	private String mailAgasajado;
	private ArrayList<Participante> participantes;
	private float montoTotal;
	private float montoPorParticipante;
	private float montoRecaudado;
	private Date fechaInicio;
	private Date fechaFin;
	private String estadoLista;
	
	public int getIdLista() {
		return idLista;
	}
	
	public boolean esLista(String nombreLista){
		return this.nombreLista.equals(nombreLista);
	}
	
	public Participante buscarParticipante(String nombreUsuario) {
		for (int i=0;i<participantes.size();i++){
			Participante p = participantes.get(i);
			if (p.esUsuario(nombreUsuario))
				return p;
		}
		return null;
	}
	
	/*Agregar participante a la lista
	 1-Busco el usuario y verifico que ya no este agregado a la lista.
	 2-Verifico que el usuario no sea administrador de la lista*/
	public void agregarParticipante(Participante p) {
		if (buscarParticipante(p.getNombreDeUsuario())==null)
			if(p.getNombreDeUsuario() != getAdministrador().getNombreDeUsuario())
				participantes.add(p);
	}
		
	/*Quitar participante de la lista*/
	public void quitarParticipante(String nombre) {
		Participante p = buscarParticipante(nombre);
		if (p!=null)
			participantes.remove(p);
	}
	
	public Lista(Usuario administrador, String nombreLista, String nombreAgasajado,
			Date fechaNacAgasajado, String mailAgasajado, ArrayList<Participante> participantes, float montoTotal,
			float montoPorParticipante, float montoRecaudado, Date fechaInicio, Date fechaFin, String estadoLista) {
		this.administrador = administrador;
		this.nombreLista = nombreLista;
		this.nombreAgasajado = nombreAgasajado;
		this.fechaNacAgasajado = fechaNacAgasajado;
		this.mailAgasajado = mailAgasajado;
		this.participantes = new ArrayList<Participante>();
		this.montoTotal = montoTotal;
		this.montoPorParticipante = montoPorParticipante;
		this.montoRecaudado = montoRecaudado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estadoLista = estadoLista;
	}

	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}

	public String getNombreLista() {
		return nombreLista;
	}

	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}

	public String getNombreAgasajado() {
		return nombreAgasajado;
	}

	public void setNombreAgasajado(String nombreAgasajado) {
		this.nombreAgasajado = nombreAgasajado;
	}

	public Date getFechaNacAgasajado() {
		return fechaNacAgasajado;
	}

	public void setFechaNacAgasajado(Date fechaNacAgasajado) {
		this.fechaNacAgasajado = fechaNacAgasajado;
	}

	public String getMailAgasajado() {
		return mailAgasajado;
	}

	public void setMailAgasajado(String mailAgasajado) {
		this.mailAgasajado = mailAgasajado;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public float getMontoPorParticipante() {
		return montoPorParticipante;
	}

	public void setMontoPorParticipante(float montoPorParticipante) {
		this.montoPorParticipante = montoPorParticipante;
	}

	public float getMontoRecaudado() {
		return montoRecaudado;
	}

	public void setMontoRecaudado(float montoRecaudado) {
		this.montoRecaudado = montoRecaudado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstadoLista() {
		return estadoLista;
	}

	public void setEstadoLista(String estadoLista) {
		this.estadoLista = estadoLista;
	}
	
	public ListaView crearVista() {
		ListaView lv = new ListaView(administrador, nombreLista, nombreAgasajado, fechaNacAgasajado, mailAgasajado, participantes, montoTotal, fechaInicio, fechaFin, estadoLista);
		return lv;
	}
	
	public void finalizarLista(){
		this.estadoLista = "Cerrada";
	}
	
}
