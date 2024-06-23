package etiquetas;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionCharla;
import model.Charla;

public class CboCharlaTag extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {	
		
		 JspWriter out = pageContext.getOut();
		 try {
			 //obtener un listado de las categorias
			 List<Charla> lstCharla = new GestionCharla().listado();			 
			 
			 //llenar las opciones del combo
			 out.println("<option value=\"-1\" >Seleccione tema...</option>");
			 for(Charla c : lstCharla) {
				 out.println( String.format("<option value=\"%d\">%s</option>", c.getId(), c.getTema()));
			 }
		} catch (Exception e) {
			System.out.println("Error en MenuTag");
		}

		 return SKIP_BODY;

			}

	public int doEndTag() throws JspException {

		return EVAL_PAGE;

	}
}
