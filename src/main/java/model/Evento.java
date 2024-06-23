package model;

public class Evento {

	private String id;
	private String fecha_reg;
	private int id_usu, id_charla;
	
	public Evento() {
	}

	public Evento(String id, String fecha_reg, int id_usu, int id_charla) {
		this.id = id;
		this.fecha_reg = fecha_reg;
		this.id_usu = id_usu;
		this.id_charla = id_charla;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFecha_reg() {
		return fecha_reg;
	}

	public void setFecha_reg(String fecha_reg) {
		this.fecha_reg = fecha_reg;
	}

	public int getId_usu() {
		return id_usu;
	}

	public void setId_usu(int id_usu) {
		this.id_usu = id_usu;
	}

	public int getId_charla() {
		return id_charla;
	}

	public void setId_charla(int id_charla) {
		this.id_charla = id_charla;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", fecha_reg=" + fecha_reg + ", id_usu=" + id_usu + ", id_charla=" + id_charla
				+ "]";
	}
}
