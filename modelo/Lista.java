package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Lista {
	private int idLista;
	private Cuenta cuenta;
	private Administrador administrador;
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
	
	public boolean esLista(int idLista){
		return this.idLista == idLista;
	}
			
}
