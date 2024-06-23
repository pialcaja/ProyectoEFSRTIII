package model;

public class MensajeBandeja {
	
	private String nom, fono, email, desc;

	public MensajeBandeja() {
	}

	public MensajeBandeja(String nom, String fono, String email, String desc) {
		this.nom = nom;
		this.fono = fono;
		this.email = email;
		this.desc = desc;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "MensajeBandeja [nom=" + nom + ", fono=" + fono + ", email=" + email + ", desc=" + desc + "]";
	}
}
