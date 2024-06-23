package model;

public class EventoCharla {

	private int id_charla, id_usu;
	private String nombre, fono, email;
	
	public EventoCharla() {
	}

	public EventoCharla(int id_charla, int id_usu, String nombre, String fono, String email) {
		this.id_charla = id_charla;
		this.id_usu = id_usu;
		this.nombre = nombre;
		this.fono = fono;
		this.email = email;
	}

	public int getId_charla() {
		return id_charla;
	}

	public void setId_charla(int id_charla) {
		this.id_charla = id_charla;
	}

	public int getId_usu() {
		return id_usu;
	}

	public void setId_usu(int id_usu) {
		this.id_usu = id_usu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EventoCharla [id_charla=" + id_charla + ", id_usu=" + id_usu + ", nombre=" + nombre + ", fono=" + fono
				+ ", email=" + email + "]";
	}
}
