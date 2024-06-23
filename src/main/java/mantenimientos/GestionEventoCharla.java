package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.EventoCharlaInterface;
import model.EventoCharla;
import utils.MySQLConexion;

public class GestionEventoCharla implements EventoCharlaInterface{

	@Override
	public List<EventoCharla> filtroRuta(int idcharla) {
		List<EventoCharla> lista = null;
		// Plantilla de base de datos
		Connection con = null;  // obtener la conexión con la BD
		PreparedStatement pst = null; // preparar sentencias
		ResultSet rs = null;    // guarda el resultado (vista) de la consulta!!
		try {
			// obtiene la conexión
			con = MySQLConexion.getConexion();
			// cadena con la sentencia
			String sql = "{CALL USP_LSTUSUARIOSPORCHARLA(?) }";
			// prepara la sentencia y setea datos necesarios (?, ...
			pst = con.prepareStatement(sql);
			pst.setInt(1, idcharla);
			// guarda el resultado, ejecutando la sentencia
			rs = pst.executeQuery();
			// pasar el resultado temporal (vista) a la lista
			lista = new ArrayList<EventoCharla>();
			while (rs.next()) {
				// crea un objeto de Tipo Producto con la información de la fila
				EventoCharla ec = new EventoCharla();
				ec.setId_charla(rs.getInt("C.ID_CHARLA"));
				ec.setId_usu(rs.getInt("U.ID_USU"));
				ec.setNombre(rs.getString("NOMBRE"));
				ec.setFono(rs.getString("U.FONO_USU"));
				ec.setEmail(rs.getString("U.EMAIL_USU"));
				// agregamos a la lista
				lista.add(ec);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con); // cierra la conexión
		}
		return lista ;
	}

}
