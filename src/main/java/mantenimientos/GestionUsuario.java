package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.UsuarioInterface;
import model.Usuario;
import utils.MySQLConexion;

public class GestionUsuario implements UsuarioInterface {

	@Override
	public int registrar(Usuario u) {
		int ok = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "INSERT INTO USUARIO VALUES (?,?,?,?,?,?,?,?);";
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getId());
			pst.setString(2, u.getNom());
			pst.setString(3, u.getApepa());
			pst.setString(4, u.getApema());
			pst.setString(5, u.getFono());
			pst.setString(6, u.getEmail());
			pst.setString(7, u.getPassword());
			pst.setInt(8, u.getTipo());
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en registrar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}

	@Override
	public int actualizar(Usuario u) {
		int ok = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "UPDATE USUARIO SET NOM_USU = ?, APEPA_USU = ?, APEMA_USU = ?, FONO_USU = ?, EMAIL_USU = ?, PASSWORD_USU = ?, ID_TIPO = ? WHERE ID_USU = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getNom());
			pst.setString(2, u.getApepa());
			pst.setString(3, u.getApema());
			pst.setString(4, u.getFono());
			pst.setString(5, u.getEmail());
			pst.setString(6, u.getPassword());
			pst.setInt(7, u.getTipo());
			pst.setInt(8, u.getId());
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}

	@Override
	public Usuario validarAcceso(Usuario u) {
		Usuario u2 = null;
		Connection con = null;  
		PreparedStatement pst = null; 
		ResultSet rs = null;    
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM USUARIO WHERE EMAIL_USU = ? AND PASSWORD_USU = ?";

			pst = con.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());

			rs = pst.executeQuery();
			while (rs.next()) {
				u2 = new Usuario();
				u2.setId(rs.getInt("ID_USU"));
				u2.setNom(rs.getString("NOM_USU"));
				u2.setApepa(rs.getString("APEPA_USU"));
				u2.setApema(rs.getString("APEMA_USU"));
				u2.setFono(rs.getString("FONO_USU"));
				u2.setEmail(rs.getString("EMAIL_USU"));
				u2.setPassword(rs.getString("PASSWORD_USU"));
				u2.setTipo(rs.getInt("ID_TIPO"));
			}
		} catch (Exception e) {
			System.out.println("Error en validarAcceso: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return u2;
	}

	@Override
	public int actualizarTipoUsuario1(Usuario u) {
		int ok = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "UPDATE USUARIO SET ID_TIPO = 2 WHERE ID_USU = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getId());
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}
	
	@Override
	public int actualizarTipoUsuario2(Usuario u) {
		int ok = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "UPDATE USUARIO SET ID_TIPO = 1 WHERE ID_USU = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getId());
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}
	

	@Override
	public Usuario obtenerTipo(int id) {
		Usuario u = null;
		// Plantilla
		Connection con = null;  
		PreparedStatement pst = null; 
		ResultSet rs = null;    
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT ID_USU, ID_TIPO FROM USUARIO WHERE ID_USU = ?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			rs = pst.executeQuery();
			while (rs.next()) {
				// Crea un objeto de Tipo Producto con la información de la fila
				u = new Usuario();
				u.setId(rs.getInt("ID_USU"));
				u.setTipo(rs.getInt("ID_TIPO"));
			}
		} catch (Exception e) {
			System.out.println("Error en obtener: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con); // cierra la conexión
		}
		return u;
	}

	@Override
	public List<Usuario> listado() {
		List<Usuario> lista = null;
		// Plantilla de base de datos
		Connection con = null;  // obtener la conexión con la BD
		PreparedStatement pst = null; // preparar sentencias
		ResultSet rs = null;    // guarda el resultado (vista) de la consulta!!
		try {
			// obtiene la conexión
			con = MySQLConexion.getConexion();
			// cadena con la sentencia
			String sql = "{SELECT * FROM USUARIO }";
			// prepara la sentencia y setea datos necesarios (?, ...
			pst = con.prepareStatement(sql);
			// guarda el resultado, ejecutando la sentencia
			rs = pst.executeQuery();
			// pasar el resultado temporal (vista) a la lista
			lista = new ArrayList<Usuario>();
			while (rs.next()) {
				// crea un objeto de Tipo Producto con la información de la fila
				Usuario u = new Usuario();
				u.setId(rs.getInt("ID_USU"));
				u.setNom(rs.getString("NOM_USU"));
				u.setApepa(rs.getString("APEPA_USU"));
				u.setApema(rs.getString("APEMA_USU"));
				u.setFono(rs.getString("FONO_USU"));
				u.setEmail(rs.getString("EMAIL_USU"));
				u.setPassword(rs.getString("PASSWORD_USU"));
				u.setTipo(rs.getInt("ID_TIPO"));
				// agregamos a la lista
				lista.add(u);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con); // cierra la conexión
		}
		return lista ;
	}
}
