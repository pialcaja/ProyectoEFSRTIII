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
 * Servlet implementation class ActualizarUsuarioServlet
 */
@WebServlet(name = "actualizar", urlPatterns = { "/actualizar" })
public class ActualizarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarUsuarioServlet() {
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
		
		int id = Integer.parseInt(request.getParameter("txtId"));
		String nom = request.getParameter("txtNombre");
		String apepa = request.getParameter("txtApepa");
		String apema = request.getParameter("txtApema");
		String fono = request.getParameter("txtFono");
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtPassword");
		int tipo = 2;
		
		int contador = 0;
		
		//Validaciones
		if (!nom.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Nombre no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("actualizar.jsp").forward(request, response);
			contador++;
		}
		
		if (!apepa.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Apellido no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("actualizar.jsp").forward(request, response);
			contador++;
		}
		
		if (!apema.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Apellido no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("actualizar.jsp").forward(request, response);
			contador++;
		}
		
		if (!fono.matches("[0-9]{9}")) {
			request.setAttribute("mensaje", "Teléfono no válido, debe contener 9 digitos");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("actualizar.jsp").forward(request, response);
			contador++;
		}
		
		if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			request.setAttribute("mensaje", "Email no válido");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("actualizar.jsp").forward(request, response);
			contador++;
		}
		
		if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,16}$")) {
			request.setAttribute("mensaje", "La contraseña debe contener de 4 a 16 caracteres, números, letras mayúsculas y minúsculas");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("actualizar.jsp").forward(request, response);
			contador++;
		}
		
		if (contador == 0) {
			//Crear el objeto
			Usuario u = new Usuario(id, nom, apepa, apema, fono, email, password, tipo);
			System.out.println(u);
			
			//Proceso en BD
			int ok = new GestionUsuario().actualizar(u);
			
			//Salidas
			if (ok == 0 ) {
				request.setAttribute("mensaje", "Error al actualizar");
				request.setAttribute("estilo", "alert alert-info");
				request.getRequestDispatcher("actualizar.jsp").forward(request, response);
			} else {
				request.setAttribute("mensaje", "Actualización exitosa");
				request.setAttribute("estilo", "alert alert-success");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}
