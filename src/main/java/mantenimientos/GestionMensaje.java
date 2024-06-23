package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import interfaces.MensajeInterface;
import model.Mensaje;
import utils.MySQLConexion;

public class GestionMensaje implements MensajeInterface{

	@Override
	public int registrar(Mensaje m) {
		int ok = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "INSERT INTO MENSAJE VALUES (?,?,?,?,?,?,?);";
			pst = con.prepareStatement(sql);
			pst.setInt(1, m.getId());
			pst.setString(2, m.getNom());
			pst.setString(3, m.getApepa());
			pst.setString(4, m.getApema());
			pst.setString(5, m.getEmail());
			pst.setString(6, m.getFono());
			pst.setString(7, m.getDesc()); 
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en registrar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}
	
}
