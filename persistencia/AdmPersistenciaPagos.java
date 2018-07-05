package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import modelo.Usuario;
import modelo.Participante;
import modelo.Lista;
import modelo.Pago;

public class AdmPersistenciaPagos {
static private AdmPersistenciaPagos instancia;
	
	private AdmPersistenciaPagos() {
	}
	
	static public AdmPersistenciaPagos getInstancia(){
		if (instancia == null) {
			instancia = new AdmPersistenciaPagos();
		}
		return instancia;
	}
	
	public int insertPago(Pago pago) {
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement
					("INSERT INTO Pagos (idUsuario, idLista, monto, fechaPago) "
							+ "VALUES(?,?,?,?)");
			//Usuario usuario = AdmPersistenciaUsuario.getInstancia().buscarUsuario(pago.getIdParticipante());
			
			Usuario user= AdmPersistenciaUsuario.getInstancia().buscarUsuario(pago.getParticipante().getNombreDeUsuario());
			Lista lista = AdmPersistenciaListas.getInstancia().buscarLista(pago.getLista().getIdLista());
			
			s.setInt(1, user.getIdUsuario());
			s.setInt(2, lista.getIdLista());
			s.setFloat(3, pago.getMonto());
			s.setDate(4, new java.sql.Date(pago.getFechaPago().getTime()));
			
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return 0;
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return -1;
		}
	}
	
	public int updatePago(Pago pago) {
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			
			PreparedStatement s = con.prepareStatement("UPDATE Listas SET " + 
					"monto = ?, " +
					"fechaPago = ?" +
					"WHERE idUsuario = ? and idLista = ?"
					);
			
			Usuario user= AdmPersistenciaUsuario.getInstancia().buscarUsuario(pago.getParticipante().getNombreDeUsuario());
			Lista lista = AdmPersistenciaListas.getInstancia().buscarLista(pago.getLista().getIdLista());
			
			s.setInt(1, user.getIdUsuario());
			s.setInt(2, lista.getIdLista());
			s.setFloat(3, pago.getMonto());
			s.setDate(4, new java.sql.Date(pago.getFechaPago().getTime()));
			
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return 0;
			
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return 1;
		}
	}
	
	public ArrayList<Pago> buscarPagos(int idLista, int idParticipante) { //Lista todos los pagos de un participante dado en una lista dada
		ArrayList<Pago> pagos = new ArrayList<Pago>();
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Pagos WHERE idLista = ? and idParticipante = ?");
			s.setInt(1, idLista);
			ResultSet rs = s.executeQuery();
			
			while (rs.next())
			{
				Participante part;
				Lista lista;
				int idPart = rs.getInt("idUsuario");
				part = (Participante)(AdmPersistenciaUsuario.getInstancia().traerUsuarioxid(idPart));
				int idList = rs.getInt("idLista");
				lista = (Lista)(AdmPersistenciaListas.getInstancia().buscarLista(idList));
				Float monto = rs.getFloat("monto");
				Date fechaPago = rs.getDate("fechaPago");
				
				PoolConnection.getPoolConnection().realeaseConnection(con);
				
				Pago newPago = new Pago(part, lista, fechaPago, monto);
				
				pagos.add(newPago);
					
			}
			return pagos;
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return null;
		}
		
	}
	
}	
