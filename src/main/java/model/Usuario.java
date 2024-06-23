package model;

public class Usuario {
	
	private int id;
	private String nom, apepa, apema, fono, email, password;
	private int tipo;
	
	public Usuario() {
	}

	public Usuario(int id, String nom, String apepa, String apema, String fono, String email, String password,
			int tipo) {
		this.id = id;
		this.nom = nom;
		this.apepa = apepa;
		this.apema = apema;
		this.fono = fono;
		this.email = email;
		this.password = password;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getApepa() {
		return apepa;
	}

	public void setApepa(String apepa) {
		this.apepa = apepa;
	}

	public String getApema() {
		return apema;
	}

	public void setApema(String apema) {
		this.apema = apema;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nom=" + nom + ", apepa=" + apepa + ", apema=" + apema + ", fono=" + fono
				+ ", email=" + email + ", password=" + password + ", tipo=" + tipo + "]";
	}
}
