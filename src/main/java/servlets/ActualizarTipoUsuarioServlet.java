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
 * Servlet implementation class ActualizarTipoUsuarioServlet
 */
@WebServlet(name = "actualizarTipo", urlPatterns = { "/actualizarTipo" })
public class ActualizarTipoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarTipoUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		Usuario u = new GestionUsuario().obtenerTipo(id);
		System.out.println(u);
		
		if(u.getId() == 1) {
			request.setAttribute("mensaje", "Error al actualizar - No puedes cambiar el tipo de usuario al administrador principal :)");
			request.setAttribute("estilo", "alert alert-info");
			request.getRequestDispatcher("listaUsuariosAdmin.jsp").forward(request, response);
		} else {
			if(u.getTipo() == 1) {
				int ok = new GestionUsuario().actualizarTipoUsuario1(u);
				if(ok == 0) {
					request.setAttribute("mensaje", "Error al actualizar");
					request.setAttribute("estilo", "alert alert-info");
					request.getRequestDispatcher("listaUsuariosAdmin.jsp").forward(request, response);
				} else {
					request.setAttribute("mensaje", "Actualización exitosa");
					request.setAttribute("estilo", "alert alert-success");
					request.getRequestDispatcher("listaUsuariosAdmin.jsp").forward(request, response);
				}
			}else {
				int ok = new GestionUsuario().actualizarTipoUsuario2(u);
				if(ok == 0) {
					request.setAttribute("mensaje", "Error al actualizar");
					request.setAttribute("estilo", "alert alert-info");
					request.getRequestDispatcher("listaUsuariosAdmin.jsp").forward(request, response);
				} else {
					request.setAttribute("mensaje", "Actualización exitosa");
					request.setAttribute("estilo", "alert alert-success");
					request.getRequestDispatcher("listaUsuariosAdmin.jsp").forward(request, response);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
