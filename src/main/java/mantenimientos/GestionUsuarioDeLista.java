package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.UsuarioDeListaInterface;
import model.UsuarioDeLista;
import utils.MySQLConexion;

public class GestionUsuarioDeLista implements UsuarioDeListaInterface{

	@Override
	public List<UsuarioDeLista> listado() {
		List<UsuarioDeLista> lista = null;
		// Plantilla de base de datos
		Connection con = null;  // obtener la conexión con la BD
		PreparedStatement pst = null; // preparar sentencias
		ResultSet rs = null;    // guarda el resultado (vista) de la consulta!!
		try {
			// obtiene la conexión
			con = MySQLConexion.getConexion();
			// cadena con la sentencia
			String sql = "{CALL USP_LSTUSUARIOS() }";
			// prepara la sentencia y setea datos necesarios (?, ...
			pst = con.prepareStatement(sql);
			// guarda el resultado, ejecutando la sentencia
			rs = pst.executeQuery();
			// pasar el resultado temporal (vista) a la lista
			lista = new ArrayList<UsuarioDeLista>();
			while (rs.next()) {
				// crea un objeto de Tipo Producto con la información de la fila
				UsuarioDeLista ul = new UsuarioDeLista();
				ul.setId(rs.getInt("U.ID_USU"));
				ul.setNombre(rs.getString("U.NOM_USU"));
				ul.setApellidos(rs.getString("APELLIDOS"));
				ul.setFono(rs.getString("U.FONO_USU"));
				ul.setEmail(rs.getString("U.EMAIL_USU"));
				ul.setTipo(rs.getString("T.NOM_TIPO"));
				// agregamos a la lista
				lista.add(ul);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con); // cierra la conexión
		}
		return lista ;
	}

	
}
