package listeners;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import mantenimientos.GestionCharla;
import mantenimientos.GestionEvento;
import model.Charla;
import model.Evento;

/**
 * Application Lifecycle Listener implementation class ReservaListener
 *
 */
@WebListener
public class ReservaListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ReservaListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	// TODO Auto-generated method stub
    	System.out.println("Se creo una sesion");
        System.out.println("ID...: " + se.getSession().getId());
        System.out.println("----------------------------------");
        
        // variables globales a nivel de sesion
        ArrayList<Charla> charlas = new ArrayList<>();
        ArrayList<Evento> eventos = new ArrayList<>();
          
        // Generar listadp
        charlas = (ArrayList<Charla>) new GestionCharla().listado();
        eventos = (ArrayList<Evento>) new GestionEvento().listado();
        
        // enviar las variables a nivel de sesion -> crear atributos
        se.getSession().setAttribute("charlas", charlas);
        se.getSession().setAttribute("eventos", eventos);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        // TODO Auto-generated method stub
    	System.out.println("Terminó una sesion");
    	System.out.println("ID...: " + se.getSession().getId());
        System.out.println("----------------------------------");
    }
	
}
