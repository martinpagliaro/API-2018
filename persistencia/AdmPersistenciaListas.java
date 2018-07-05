package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import modelo.Administrador;
import modelo.Usuario;
import modelo.Participante;
import modelo.Lista;

public class AdmPersistenciaListas {
	static private AdmPersistenciaListas instancia;
	
	private AdmPersistenciaListas() {
	}
	
	static public AdmPersistenciaListas getInstancia(){
		if (instancia == null) {
			instancia = new AdmPersistenciaListas();
		}
		return instancia;
	}
	
	
	public ArrayList<Participante> traerParticipantes (int idLista) {
		Participante u = null;
		ArrayList<Participante> participantes=new ArrayList<Participante>();
		
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("Select idUsuario From ParticipantesListas Where idLista = ?");
			s.setInt(1, idLista);
			ResultSet rs = s.executeQuery();
		
			while (rs.next())
			{
				int idUsuario = rs.getInt("idUsuario");
				u = (Participante)(AdmPersistenciaUsuario.getInstancia().traerUsuarioxid(idUsuario));
				participantes.add(u);
			
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);	
				return participantes;
			
			} catch (Exception e) {
				System.out.println("Error Query: " + e.getMessage());
				return null;
			}
	}
	public Lista buscarLista(int idLista) {
		//Usuario u = null;
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Listas WHERE idLista = ?");
			s.setInt(1, idLista);
			ResultSet rs = s.executeQuery();
			
		
			 
			while (rs.next())
			{
				Usuario adm;
				int idAdministrador = rs.getInt("administrador");
				adm = (Administrador)(AdmPersistenciaUsuario.getInstancia().traerUsuarioxid(idAdministrador));
				String nombreLista = rs.getString("nombrelista");
				String nombreAgasajado = rs.getString("nombreAgasajado");
				Date fechaNacAgasajado = rs.getDate("fechaNacAgasajado");
				String mailAgasajado = rs.getString("mailAgasajado");
				Float montoTotal = rs.getFloat("montoTotal");
				Float montoParticipante = rs.getFloat("montoParticipante");
				Float montoRecaudado = rs.getFloat("montoRecaudado");
				Date fechaInicio = rs.getDate("fechaInicio");//TRAER FECHA
				Date fechaFin = rs.getDate("fechaFin");
				String estadoLista = rs.getString("estadoUsuario");
				
				PoolConnection.getPoolConnection().realeaseConnection(con);
				
				ArrayList<Participante> participantes=this.traerParticipantes(idLista);
				
				return new Lista(adm, nombreLista, nombreAgasajado, fechaNacAgasajado, 
						mailAgasajado, participantes ,montoTotal, montoParticipante, montoRecaudado,fechaInicio, fechaFin, estadoLista);
						
			}
			
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return null;
		}
		return null;
	}
	
	public int insertLista (Lista lista) {
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement
					("\n" + 
							"INSER INTO Listas (Administrador, nombreLista, nombreAgasajado, "
							+ "fechaNacAgasajado, mailAgasajado, montoTotal, montoParticipante, montoRecaudado, "
							+ "fechaInicio, fechaFin, estadoLista) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			Usuario adm = AdmPersistenciaUsuario.getInstancia().buscarUsuario(lista.getAdministrador().getNombreDeUsuario());
			
			
			s.setInt(1, adm.getIdUsuario());
			s.setString(2, lista.getNombreLista());
			s.setString(3, lista.getNombreAgasajado());
			s.setDate(4, new java.sql.Date(lista.getFechaNacAgasajado().getTime()));
			s.setString(5, lista.getMailAgasajado());
			s.setFloat(6, lista.getMontoTotal());
			s.setFloat(7, lista.getMontoPorParticipante());
			s.setFloat(8, lista.getMontoRecaudado());
			s.setDate(9, new java.sql.Date(lista.getFechaInicio().getTime()));
			s.setDate(10, new java.sql.Date(lista.getFechaFin().getTime()));
			s.setString(11, lista.getEstadoLista());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return 0;
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return -1;
		}
	}
	
	
	public int updateLista(Lista lista) {
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*
			(Administrador, nombreLista, nombreAgasajado, fechaNacAgasajado, 
					mailAgasajado, montoTotal, montoParticipante, montoRecaudado, fechaInicio, fechaFin, estadoLista)
			*/
			
			PreparedStatement s = con.prepareStatement("UPDATE Listas SET " + 
					"Administrador = ?, " +
					"nombreLista = ?, " +
					"nombreAgasajado = ?, " +
					"fechaNacAgasajado = ?, " +
					"mailAgasajado = ? " +
					"montoTotal = ? " +
					"montoParticipante = ? " +
					"montoRecaudado = ? " +
					"fechaInicio = ? " +
					"fechaFin = ? " +
					"estadoLista = ? " +
					"WHERE idLista = ?"
					);
			Participante adm = (Participante) AdmPersistenciaUsuario.getInstancia().buscarUsuario(
							lista.getAdministrador().getNombreDeUsuario());

			s.setInt(1, adm.getIdUsuario());
			s.setString(2, lista.getNombreLista());
			s.setString(3, lista.getNombreAgasajado());
			s.setDate(4, new java.sql.Date(lista.getFechaNacAgasajado().getTime()));
			s.setString(5, lista.getMailAgasajado());
			s.setFloat(6, lista.getMontoTotal());
			s.setFloat(7, lista.getMontoPorParticipante());
			s.setFloat(8, lista.getMontoRecaudado());
			s.setDate(9, new java.sql.Date(lista.getFechaInicio().getTime()));
			s.setDate(10, new java.sql.Date(lista.getFechaFin().getTime()));
			s.setString(11, lista.getEstadoLista());
			
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return 0;
			
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return 1;
		}
	}
	
}
