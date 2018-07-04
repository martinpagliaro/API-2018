package controlador;

import java.util.ArrayList;
import java.util.Date;

import modelo.Lista;
import modelo.ObserverPago;
import modelo.Pago;

public class PagoController implements ObserverPago{
	
	private ArrayList<Pago> pagos;
	private static PagoController instancia;
	
	static public PagoController getInstancia() {
		if(PagoController.instancia == null) {
			PagoController.instancia = new PagoController();
		}
		return PagoController.instancia;
	}
	
	private PagoController(){
		pagos = new ArrayList<Pago>();
	}

	public boolean NotificarPago(String nombreLista, String nombreUsuario, Date fecha, float monto) {
		return ListaController.getInstancia().NotificarPago(nombreLista, nombreUsuario, fecha, monto);
	}
	
}
