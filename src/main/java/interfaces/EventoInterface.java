package interfaces;

import java.util.ArrayList;
import java.util.List;

import model.Charla;
import model.Evento;

public interface EventoInterface {

	public String generarIdEvento();

	public int registrarEvento(Evento ev, ArrayList<Charla> cha);
	
	public List<Evento> listado();

}
