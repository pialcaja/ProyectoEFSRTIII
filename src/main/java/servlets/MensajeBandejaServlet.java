package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionMensajeBandeja;
import model.MensajeBandeja;

/**
 * Servlet implementation class MensajeBandejaServlet
 */
@WebServlet(name = "bandeja", urlPatterns = { "/bandeja" })
public class MensajeBandejaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MensajeBandejaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Utilizó el servlet de listado de mensajes");
		List<MensajeBandeja> lstMensajes = new GestionMensajeBandeja().listado();
		request.setAttribute("lstMensajes", lstMensajes);
		// enviar a la página
		request.getRequestDispatcher("bandejaAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
