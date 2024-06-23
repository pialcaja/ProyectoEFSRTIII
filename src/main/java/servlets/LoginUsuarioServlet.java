package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionUsuario;
import model.Usuario;

/**
 * Servlet implementation class LoginUsuarioServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsuarioServlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("Entró al Servlet Login");
		
		//Entradas
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		
		//Objeto
		Usuario u = new Usuario();
		u.setEmail(email);
		u.setPassword(password);
		
		//Llamar a la gestion
		u = new GestionUsuario().validarAcceso(u);
		
		// valida el acceso
		if (u == null || !u.getPassword().equals(password)) {
			request.setAttribute("mensaje", "Usuario o clave incorrecto!!!");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			if(u.getTipo() == 1) {
				request.setAttribute("mensaje", "Bienvenido(a) " + u.getNom());
				request.getSession().setAttribute("u", u);
				request.setAttribute("estilo", "alert alert-success");
				request.getRequestDispatcher("bandejaAdmin.jsp").forward(request, response);
			} else {
				request.setAttribute("mensaje", "Bienvenido(a) " + u.getNom());
				request.getSession().setAttribute("u", u);
				request.setAttribute("estilo", "alert alert-success");
				request.getRequestDispatcher("index-login.jsp").forward(request, response);
			}
		}
	}

}
