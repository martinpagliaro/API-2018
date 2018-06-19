package controlador;

import java.util.ArrayList;
import java.util.Date;

import modelo.Usuario;
import modelo.Lista;
import modelo.Participante;

public class ListaController {
	
	private ArrayList<Lista> listas;
	private static ListaController instancia;
	
	static public ListaController getInstancia() {
		if(ListaController.instancia == null) {
			ListaController.instancia = new ListaController();
		}
		return ListaController.instancia;
	}
	
	private ListaController(){
		listas = new ArrayList<Lista>();
	}
	
	public Lista buscarLista(String nombreLista){
		for (int i=0;i<listas.size();i++){
			Lista l = listas.get(i);
			if (l.esLista(nombreLista))
				return l;
		}
		return null;
	}
	
	/*Busca todas las listas activas*/
	public ArrayList<Lista> buscarParticipanteEnLista(String nombreUsuario){
		ArrayList<Lista> aux = new ArrayList<>();
		for (int i=0; i<listas.size(); i++){
			ArrayList<Participante> p = listas.get(i).getParticipantes();
			for (int y=0; y<p.size(); y++){
				if (p.get(y).getNombreDeUsuario().equals(nombreUsuario)){
					aux.add(listas.get(i));
				}
			}
		}
		return aux;
	}
	
	
	/*Alta de lista*/
	public int altaLista (Usuario administrador, String nombreLista, String nombreAgasajado,
			Date fechaNacAgasajado, String mailAgasajado, ArrayList<Participante> participantes, float montoTotal,
			float montoPorParticipante, float montoRecaudado, Date fechaInicio, Date fechaFin, String estadoLista){
		if (buscarLista(nombreLista) == null) {
			Lista l = new Lista (administrador, nombreLista, nombreAgasajado,
					fechaNacAgasajado, mailAgasajado, participantes, montoTotal,
					montoPorParticipante, montoRecaudado, fechaInicio, fechaFin, estadoLista);
			listas.add(l);
			return 0; //Lista creada
		}
		return 1; //Ya existe la lista
	}
	
	/*Baja de lista*/
	public boolean bajaLista (String nombreLista){
		Lista l = buscarLista(nombreLista);
		if (l!=null) {
			listas.remove(l);
			return true;
		}
		return false;
	}
	
	/*Modificacion de lista*/
	public int modificarLista(String nombreLista, String nombreAgasajado,
			String mailAgasajado, Date fechaNacAgasajado, Date fechaFin, float montoTotal) {
		Lista l = buscarLista(nombreLista);
		if (l!=null){
			l.setFechaFin(fechaFin);
			l.setMailAgasajado(mailAgasajado);
			l.setNombreAgasajado(nombreAgasajado);
			l.setFechaNacAgasajado(fechaNacAgasajado);
			l.setMontoTotal(montoTotal);
			return 0;
		}
		return 1;
	}
	
	public ListaView mostrarLista (String nombreLista){
		Lista lista = buscarLista(nombreLista);
		if (lista!=null) {
			return lista.crearVista();
		}
		return null;
	}
	
}
