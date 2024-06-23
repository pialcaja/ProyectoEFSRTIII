package model;

public class UsuarioDeLista {

	private int id;
	private String nombre, apellidos, fono, email, tipo;

	public UsuarioDeLista() {
	}

	public UsuarioDeLista(int id, String nombre, String apellidos, String fono, String email, String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fono = fono;
		this.email = email;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "UsuarioDeLista [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fono=" + fono
				+ ", email=" + email + ", tipo=" + tipo + "]";
	}
}
