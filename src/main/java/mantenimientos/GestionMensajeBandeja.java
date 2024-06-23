package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.MensajeBandejaInterface;
import model.MensajeBandeja;
import utils.MySQLConexion;

public class GestionMensajeBandeja implements MensajeBandejaInterface {

	@Override
	public List<MensajeBandeja> listado() {
		List<MensajeBandeja> lista = null;
		// Plantilla de base de datos
		Connection con = null;  // obtener la conexión con la BD
		PreparedStatement pst = null; // preparar sentencias
		ResultSet rs = null;    // guarda el resultado (vista) de la consulta!!
		try {
			// obtiene la conexión
			con = MySQLConexion.getConexion();
			// cadena con la sentencia
			String sql = "{CALL USP_LSTMENSAJES() }";
			// prepara la sentencia y setea datos necesarios (?, ...
			pst = con.prepareStatement(sql);
			// guarda el resultado, ejecutando la sentencia
			rs = pst.executeQuery();
			// pasar el resultado temporal (vista) a la lista
			lista = new ArrayList<MensajeBandeja>();
			while (rs.next()) {
				// crea un objeto de Tipo Producto con la información de la fila
				MensajeBandeja m = new MensajeBandeja();
				m.setNom(rs.getString("NOMBRE"));
				m.setFono(rs.getString("FONO"));
				m.setEmail(rs.getString("EMAIL"));
				m.setDesc(rs.getString("DESC_MENSAJE"));
				// agregamos a la lista
				lista.add(m);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con); // cierra la conexión
		}
		return lista ;
	}

}
