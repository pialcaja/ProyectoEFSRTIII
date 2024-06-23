package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionMensaje;
import model.Mensaje;

/**
 * Servlet implementation class RegistroUsuarioServlet
 */
@WebServlet(name = "regmsg", urlPatterns = { "/regmsg" })
public class RegistroMensajeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroMensajeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Entró al Servlet usando método Get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("Entró al Servlet usando método Post");
		
		//Entradas
		String nom = request.getParameter("txtNombre");
		String apepa = request.getParameter("txtApepa");
		String apema = request.getParameter("txtApema");
		String email = request.getParameter("txtEmail");
		String fono = request.getParameter("txtFono");
		String desc = request.getParameter("txtMensaje");
		
		int contador = 0;
		
		//Validaciones
		if (!nom.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Nombre no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			contador++;
		}
		
		if (!apepa.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Apellido no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			contador++;
		}
		
		if (!apema.matches("^[A-ZÑ][a-zA-ZÑñáéíóúüÁÉÍÓÚÜ\\s]*$")) {
			request.setAttribute("mensaje", "Apellido no válido, debe iniciar con mayúscula y contener sólo letras");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			contador++;
		}
		
		if (!fono.matches("[0-9]{9}")) {
			request.setAttribute("mensaje", "Teléfono no válido, debe contener 9 digitos");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			contador++;
		}
		
		if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			request.setAttribute("mensaje", "Email no válido");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			contador++;
		}
		
		//Creacion de objeto
		if (contador == 0) {
			Mensaje m = new Mensaje(0, nom, apepa, apema, email, fono, desc);
			System.out.println(m);
			//Validacion de registro
			int ok = new GestionMensaje().registrar(m);
			
			//Salidas
			if (ok==0) {
				request.setAttribute("mensaje", "Error al enviar mensaje");
				request.setAttribute("estilo", "alert alert-danger");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("mensaje", "Mensaje enviado!");
				request.setAttribute("estilo", "alert alert-success");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
