package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionUsuarioDeLista;
import model.UsuarioDeLista;

/**
 * Servlet implementation class UsuarioDeListaServlet
 */
@WebServlet(name = "usuarios", urlPatterns = { "/usuarios" })
public class UsuarioDeListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioDeListaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Utilizó el servlet de listado de usuarios");
		List<UsuarioDeLista> lstUsuarios = new GestionUsuarioDeLista().listado();
		request.setAttribute("lstUsuarios", lstUsuarios);
		request.getRequestDispatcher("listaUsuariosAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
