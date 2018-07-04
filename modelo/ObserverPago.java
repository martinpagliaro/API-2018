package modelo;

import java.util.Date;

public interface ObserverPago {
	
	public boolean NotificarPago(String nombreLista, String nombreUsuario, Date fecha, float monto);
	
}
