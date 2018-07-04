package modelo;

import java.util.Date;

public class Pago {
	
	private Usuario usuario;
	private Lista lista;
	private Date fechaPago;
	private float monto;
	
	
	public Pago(Usuario usuario, Lista lista, Date fechaPago, float monto) {
		super();
		this.usuario = usuario;
		this.lista = lista;
		this.fechaPago = fechaPago;
		this.monto = monto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}
	
}
