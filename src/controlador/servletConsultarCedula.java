package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.DTO_Persona;

/**
 * Servlet implementation class servletConsultarCedula
 */
@WebServlet(name = "servletConsultarCedula", urlPatterns = {"/servletConsultarCedula"})
@MultipartConfig
public class servletConsultarCedula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletConsultarCedula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String pCedula = request.getParameter("cedula");

		DTO_Persona persona = new DTO_Persona();
		persona.setCedula(Integer.parseInt(pCedula));
		persona = controladorWeb.obtenerDatosPorCedula(persona);
        response.setContentType("text/plain");
        response.getWriter().println(persona.toString());        
 
		
	}

}
