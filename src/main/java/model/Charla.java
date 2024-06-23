package model;

public class Charla {

	private int id;
	private String tema;
	private int cupos;
	
	public Charla() {
	}

	public Charla(int id, String tema, int cupos) {
		this.id = id;
		this.tema = tema;
		this.cupos = cupos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	@Override
	public String toString() {
		return "Charla [id=" + id + ", tema=" + tema + ", cupos=" + cupos + "]";
	}
}
