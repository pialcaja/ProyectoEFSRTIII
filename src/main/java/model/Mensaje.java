package model;

public class Mensaje {
	private int id;
	private String nom, apepa, apema, email, fono, desc;
	
	public Mensaje() {
	}

	public Mensaje(int id, String nom, String apepa, String apema, String email, String fono, String desc) {
		this.id = id;
		this.nom = nom;
		this.apepa = apepa;
		this.apema = apema;
		this.email = email;
		this.fono = fono;
		this.desc = desc;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", nom=" + nom + ", apepa=" + apepa + ", apema=" + apema + ", email=" + email
				+ ", fono=" + fono + ", desc=" + desc + "]";
	}
}
