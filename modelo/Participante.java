package modelo;

import java.sql.Date;

public class Participante extends Usuario{
	private int idLista;
	private boolean pagado;
	private float montoPago;
		
	public Participante(int idUsuario, String nombre, Date fechaNac, String mail, Password password, int idRole,
			boolean estadoUsuario, boolean pagado, float montoPago) {
		super(idUsuario, nombre, fechaNac, mail, password, idRole, estadoUsuario);
		this.pagado = pagado;
		this.montoPago = montoPago;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	public boolean esParticipante(int idUsuario, int idLista){
		return this.idUsuario == idUsuario && this.idLista == idLista;
	}
	

}
