package modelo;

import java.util.Date;

public class Pago {
	
	private Participante participante;
	private Lista lista;
	private Date fechaPago;
	private float monto;
	
	
	public Pago(Participante participante, Lista lista, Date fechaPago, float monto) {
		super();
		this.participante = participante;
		this.lista = lista;
		this.fechaPago = fechaPago;
		this.monto = monto;
	}


	public Participante getParticipante() {
		return participante;
	}


	public void setParticipante(Participante participante) {
		this.participante = participante;
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
