package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Cuenta {
	
	private int idCuenta;
	private int idLista;
	private Date fechaPago;
	private float monto;
	private ArrayList<Pago> pagos;
	
	public Cuenta(int idCuenta, int idLista, Date fechaPago, float monto) {
		super();
		this.idCuenta = idCuenta;
		this.idLista = idLista;
		this.fechaPago = fechaPago;
		this.monto = monto;
		pagos = new ArrayList<Pago>();
	}
	
}
