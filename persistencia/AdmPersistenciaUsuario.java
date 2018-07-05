
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import modelo.Administrador;
import modelo.Usuario;
import modelo.Participante;

public class AdmPersistenciaUsuario {
	static private AdmPersistenciaUsuario instancia;
	
	private AdmPersistenciaUsuario() {
	}
	
	static public AdmPersistenciaUsuario getInstancia(){
		if (instancia == null) {
			instancia = new AdmPersistenciaUsuario();
		}
		return instancia;
	}
	
	public Usuario traerUsuarioxid(int id){
		Usuario u = null;
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Usuarios WHERE idUsuario = ?");
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();
			while (rs.next())
			{
				String nombreDeUsuario = rs.getString("nombreDeUsuario");
				int idUsuario =rs.getInt("idUsuario");
				String nombre = rs.getString(" nombre");
				String mail = rs.getString("mail");
				Date fechaNac = rs.getDate("fechaNac");//TRAER FECHA
				Date fechaCreacion = rs.getDate("fechaCreacion");
				String pswd = rs.getString("pswd");
				Boolean estadoUsuario = rs.getBoolean("estadoUsuario");
				Boolean admin = rs.getBoolean("admin");
				PoolConnection.getPoolConnection().realeaseConnection(con);
				
				if (admin) {
					return new Administrador(idUsuario, nombreDeUsuario, pswd, fechaCreacion, estadoUsuario);
					
				}
				else {
					
					//public Participante(String nombreDeUsuario, Password password, LocalDateTime fechaCreacion, boolean estadoUsuario,
					//		String nombre, String mail, Date fechaNac) 
					
					return new Participante(idUsuario, nombreDeUsuario, pswd, fechaCreacion, estadoUsuario, nombre, mail, fechaNac);
					
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return null;
		}
		return null;
	}
	
		
	
	
	public Usuario buscarUsuario(String usuario) {
		Usuario u = null;
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("SELECT * FROM Usuarios WHERE Nombre = ?");
			s.setString(1, usuario);
			ResultSet rs = s.executeQuery();
			while (rs.next())
			{
				String nombreDeUsuario = rs.getString("nombreDeUsuario");
				String nombre = rs.getString("nombre");
				String mail = rs.getString("mail");
				Date fechaNac = rs.getDate("fechaNac");//TRAER FECHA
				Date fechaCreacion = rs.getDate("fechaCreacion");
				String pswd = rs.getString("pswd");
				Boolean estadoUsuario = rs.getBoolean("estadoUsuario");
				Boolean admin = rs.getBoolean("admin");
				int id=rs.getInt("idUsuario");
				PoolConnection.getPoolConnection().realeaseConnection(con);
				
				if (admin) {
					return new Administrador(id, nombreDeUsuario, pswd, fechaCreacion, estadoUsuario);
					
				}
				else {
					
					//public Participante(String nombreDeUsuario, Password password, LocalDateTime fechaCreacion, boolean estadoUsuario,
					//		String nombre, String mail, Date fechaNac) 
					
					Participante part;
					return new Participante(id, nombreDeUsuario, pswd, fechaCreacion, estadoUsuario, nombre, mail, fechaNac);
					
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return null;
		}
		return null;
	}
	
	public int insertUsuario(Participante part) {
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("INSERT INTO usuarios (nombreDeUsuario, pswd, estadoUsuario, fechaCreacion, nombre, mail, fechaNac, admin) VALUES (?,?,?,?,?,?,?,?,?)");
			s.setString(1, part.getNombreDeUsuario());
			s.setString(2, part.getPassword());
			s.setBoolean(3, part.getEstadoUsuario());
			s.setDate(4, new java.sql.Date (part.getFechaCreacion().getTime()));
			s.setString(5, part.getNombre());
			s.setString(6, part.getMail());
			s.setDate(7, new java.sql.Date (part.getFechaNac().getTime()));
			s.setBoolean(8, false);//False porque no es admin
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return 0;
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return -1;
		}
	}
	
	public int insertUsuario(Administrador adm) {
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement(
					"INSERT INTO usuarios (nombreDeUsuario, pswd, estadoUsuario, fechaCreacion, admin) VALUES (?,?,?,?,?)");
			//Cargamos solo los datos necesarios para un administrador.
			s.setString(1, adm.getNombreDeUsuario());
			s.setString(2, adm.getPassword());//Falla el setString porque hay que poner return String en getPassword en lugar del tipo Password
			s.setBoolean(3, adm.getEstadoUsuario());
			s.setDate(4, new java.sql.Date(adm.getFechaCreacion().getTime()));
			s.setBoolean(8, true);//true porque es admin
			s.execute();
			
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return 0;
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return -1;
		}
	}
	
	public int updateUsuario(Usuario usuario) {
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			if (usuario instanceof Participante) {
				Participante u = (Participante) usuario;
				
				//(nombreDeUsuario, pswd, estadoUsuario, fechaCreacion, nombre, mail, fechaNac, admin)
				PreparedStatement s = con.prepareStatement("UPDATE usuarios SET " + 
						"nombre = ?, " +
						"fechaNac = ?, " +
						"mail = ?, " +
						"pswd = ?, " +
						"estadoUsuario = ? " + 
						"WHERE nombreDeUsuario = ?"
						);
				s.setString(1, u.getNombre());
				s.setDate(2, new java.sql.Date (u.getFechaNac().getTime()));
				s.setString(3, u.getMail());
				s.setString(4, u.getPassword());//Corregir el tipo de dato que trae getPassword
				s.setBoolean(5, u.getEstadoUsuario());
				s.setString(6, u.getNombreDeUsuario());
				s.execute();
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return 0;
			}
			else if (usuario instanceof Administrador) {
				Administrador u = (Administrador) usuario;
				//(nombreDeUsuario, pswd, estadoUsuario, fechaCreacion, admin)
				PreparedStatement s = con.prepareStatement("UPDATE usuarios SET " + 
						"passwordString = ?, " +
						"estadoUsuario = ? " +
						"WHERE nombreDeUsuario = ?"
						);
				s.setString(1, u.getPassword());//Corregir el tipo de dato que trae getPassword
				s.setBoolean(2, u.getEstadoUsuario());
				s.setString(3, u.getNombreDeUsuario());
				s.execute();
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return 0;
			}
			else {
				return 2;
			}
			
		} catch (Exception e) {
			System.out.println("Error Query: " + e.getMessage());
			return 1;
		}
	}
	
	
}
