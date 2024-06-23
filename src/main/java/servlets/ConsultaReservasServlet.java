package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionEvento;
import mantenimientos.GestionEventoCharla;
import model.Evento;
import model.EventoCharla;

/**
 * Servlet implementation class ConsultaReservasServlet
 */
@WebServlet(name = "consulta", urlPatterns = { "/consulta" })
public class ConsultaReservasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaReservasServlet() {
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
		int id_charla = Integer.parseInt(request.getParameter("cboCharlas"));
		
		if(id_charla < 1) {
			request.setAttribute("mensaje", "Seleccione una charla");
			request.setAttribute("estilo", "alert alert-info");
			request.getRequestDispatcher("listaReservasAdmin.jsp").forward(request, response);
			return;
		} else {
			EventoCharla ev = new EventoCharla();
			ev.setId_charla(id_charla);
			
			List<EventoCharla> lstEC = new GestionEventoCharla().filtroRuta(id_charla);
			
			request.setAttribute("lstEC", lstEC);
			request.setAttribute("mensaje", "Usuarios registrados en la charla con el Id: " + id_charla);
			request.setAttribute("estilo", "alert alert-info");
			request.getRequestDispatcher("listaReservasAdmin.jsp").forward(request, response);
		}
	}

}
