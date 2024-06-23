package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.CharlaInterface;
import model.Charla;
import utils.MySQLConexion;

public class GestionCharla implements CharlaInterface{

	@Override
	public List<Charla> listado() {
		List<Charla> lista = null;
		// Plantilla de base de datos
		Connection con = null;  // obtener la conexión con la BD
		PreparedStatement pst = null; // preparar sentencias
		ResultSet rs = null;    // guarda el resultado (vista) de la consulta!!
		try {
			// obtiene la conexión
			con = MySQLConexion.getConexion();
			// cadena con la sentencia
			String sql = "SELECT * FROM CHARLA ";
			// prepara la sentencia y setea datos necesarios (?, ...
			pst = con.prepareStatement(sql);
			// guarda el resultado, ejecutando la sentencia
			rs = pst.executeQuery();
			// pasar el resultado temporal (vista) a la lista
			lista = new ArrayList<Charla>();
			while (rs.next()) {
				// crea un objeto de Tipo Producto con la información de la fila
				Charla c = new Charla();
				c.setId(rs.getInt("ID_CHARLA"));
				c.setTema(rs.getString("TEMA"));
				c.setCupos(rs.getInt("CUPOS"));
				// agregamos a la lista
				lista.add(c);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con); // cierra la conexión
		}
		return lista ;
	}
}
