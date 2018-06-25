package controlador;

import java.sql.Date;
import java.util.ArrayList;

import modelo.Cuenta;

public class CuentaController {
	
	private static CuentaController instancia;
	private ArrayList<Cuenta> cuentas;
	
	static public CuentaController getInstancia() {
		if(CuentaController.instancia == null) {
			CuentaController.instancia = new CuentaController();
		}
		return CuentaController.instancia;
	}
	
	public void altaCuenta(int idCuenta, int idLista, Date fechaPago, float monto){
		Cuenta c = new Cuenta (idCuenta, idLista, fechaPago, monto);
		cuentas.add(c);
	}

}
