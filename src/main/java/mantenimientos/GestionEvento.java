package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.EventoInterface;
import model.Charla;
import model.Evento;
import utils.MySQLConexion;

public class GestionEvento implements EventoInterface{

	@Override
	public String generarIdEvento() {
		String numero = "E0001";   // valor x default para el autogenerado
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT substr(max(ID_EVENTO),2) FROM EVENTO";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				numero = String.format("E%04d", rs.getInt(1) + 1);
			}
		} catch (Exception e) {
			System.out.println("Error en generarIdEvento : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return numero;
	}

	@Override
	public int registrarEvento(Evento ev, ArrayList<Charla> cha) {
		int rs = 0;  // valor x default en caso de error
		// Plantilla
		Connection con = null;
		PreparedStatement pst1 = null;   // registrar en Evento
		PreparedStatement pst2 = null;   // actualizar las Charlas
		try {
			con = MySQLConexion.getConexion();
			
			con.setAutoCommit(false);   

			String sql1 = "INSERT INTO EVENTO VALUES (?,curdate(),?,?)";
			pst1 = con.prepareStatement(sql1);
			ev.setId(generarIdEvento());
			// registra el evento
			pst1.setString(1, ev.getId());
			pst1.setInt(2, ev.getId_usu());
			pst1.setInt(3, ev.getId_charla());
			rs = pst1.executeUpdate();
			
			// actualiza la  charla
			String sql2 = "UPDATE CHARLA SET CUPOS = CUPOS - ? WHERE ID_CHARLA = ?";
			pst2 = con.prepareStatement(sql2);
			pst2.setInt(1, 1);
			pst2.setInt(2, ev.getId_charla());

			rs += pst2.executeUpdate();
			
			//*******************************
			//si no hay errores, se confirma las operaciones (transacciones)
			// transaccion: es cualquier proceso de actualizar o grabar
			con.commit();
		} catch (Exception e) {
			System.out.println("Error en registrar : " + e.getMessage());
			rs = 0;
			try {
				//deshacer lo registro o actualizado en este proceso
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al cerrar : " + e1.getMessage());
			}
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public List<Evento> listado() {
		List<Evento> lista = null;
		// Plantilla de base de datos
		Connection con = null;  // obtener la conexión con la BD
		PreparedStatement pst = null; // preparar sentencias
		ResultSet rs = null;    // guarda el resultado (vista) de la consulta!!
		try {
			// obtiene la conexión
			con = MySQLConexion.getConexion();
			// cadena con la sentencia
			String sql = "SELECT * FROM EVENTO ";
			// prepara la sentencia y setea datos necesarios (?, ...
			pst = con.prepareStatement(sql);
			// guarda el resultado, ejecutando la sentencia
			rs = pst.executeQuery();
			// pasar el resultado temporal (vista) a la lista
			lista = new ArrayList<Evento>();
			while (rs.next()) {
				// crea un objeto de Tipo Producto con la información de la fila
				Evento ev = new Evento();
				ev.setId(rs.getString("ID_EVENTO"));
				ev.setFecha_reg(rs.getString("FECHA_REG"));
				ev.setId_usu(rs.getInt("ID_USU"));
				ev.setId_charla(rs.getInt("ID_CHARLA"));
				// agregamos a la lista
				lista.add(ev);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con); // cierra la conexión
		}
		return lista ;
	}
}
