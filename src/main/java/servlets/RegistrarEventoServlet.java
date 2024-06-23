package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionEvento;
import model.Charla;
import model.Evento;

/**
 * Servlet implementation class RegistrarEventoServlet
 */
@WebServlet(name = "regEvento", urlPatterns = { "/regEvento" })
public class RegistrarEventoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarEventoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Evento ev = new Evento();
		int idUsu = Integer.parseInt(request.getParameter("cod"));
		int idCharla = Integer.parseInt(request.getParameter("cboCharlas"));
		
		// Validar si ha selecionado una charla
		if(idCharla < 1) {
			request.setAttribute("mensaje", "Seleccione un charla");
			request.setAttribute("estilo", "alert alert-info");
			request.getRequestDispatcher("eventos.jsp").forward(request, response);
			return;
		} else {
			ev.setId_usu(idUsu);
			ev.setId_charla(idCharla);
			
			// obtener las variables de session de la lista
	        ArrayList<Charla> charlas = (ArrayList<Charla>) request.getSession().getAttribute("charlas");
	        ArrayList<Evento> eventos = (ArrayList<Evento>) request.getSession().getAttribute("eventos");
	        
	        // Validar si el usuario ya está registrado la charla que eligio
	        for(Evento ex : eventos) {
	        	if(ex.getId_usu() == idUsu && ex.getId_charla() == idCharla) {
	        		request.setAttribute("mensaje", "Usted ya está registrado en esta charla");
					request.setAttribute("estilo", "alert alert-danger");
					request.getRequestDispatcher("eventos.jsp").forward(request, response);
					return;
	        	}
	        }
	        
	        // Validacion si la charla tiene cupos disponibles
	        for (Charla c : charlas) {
				if (c.getId() == idCharla ) {
					if (c.getCupos() == 0) {
						request.setAttribute("mensaje", "El evento de " + c.getTema() + " no cuenta con cupos disponibles");
						request.setAttribute("estilo", "alert alert-danger");
						request.getRequestDispatcher("eventos.jsp").forward(request, response);
						return;
					} else {
						eventos.add(ev);
		        		int ok = new GestionEvento().registrarEvento(ev, charlas);
				        if(ok != 0) {
				        	c.setCupos(c.getCupos() - 1);
					        //envia las variables a nivel de session
					        request.getSession().setAttribute("charlas", charlas);
					        request.setAttribute("mensaje", "Registro exitoso");
							request.setAttribute("estilo", "alert alert-success");
							request.getRequestDispatcher("eventos.jsp").forward(request, response);
					        return;
				        } else {
				        	request.setAttribute("mensaje", "Registro cancelado");
							request.setAttribute("estilo", "alert alert-danger");
							request.getRequestDispatcher("eventos.jsp").forward(request, response);
				        }
					}
				}
			}
		}
	}

}
