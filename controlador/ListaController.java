package controlador;

import java.util.ArrayList;

import modelo.Lista;

public class ListaController {
	
	private ArrayList<Lista> listas;
	private static ListaController instancia;
	
	static public ListaController getInstancia() {
		if(ListaController.instancia == null) {
			ListaController.instancia = new ListaController();
		}
		return ListaController.instancia;
	}
	
	public Lista buscarLista(int idLista){
		for (int i=0;i<listas.size();i++){
			Lista l = listas.get(i);
			if (l.esLista(idLista))
				return l;
		}
		return null;
	}
	
}
