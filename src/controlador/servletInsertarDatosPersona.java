package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.DTO_InformacionAcademica;
import dto.DTO_InformacionProfesional;
import dto.DTO_Persona;

/**
 * Servlet implementation class servletInsertarDatosPersona
 */
@WebServlet("/servletInsertarDatosPersona")
public class servletInsertarDatosPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletInsertarDatosPersona() {
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
		// TODO Auto-generated method stub
		
	    request.setCharacterEncoding("UTF-8");
	    
	    DTO_Persona cientifico = new DTO_Persona();
		
		
	    //*****************Sección Datos Personales*********************\\
	    
		String cedula = request.getParameter("ced");
		String nombre = request.getParameter("nombre");
		String apellido_1 = request.getParameter("apellido_1");
		String apellido_2 = request.getParameter("apellido_2");
	   	String fch_nacimiento = request.getParameter("fch-nacimiento");
		String provincia = request.getParameter("provincia");
		String canton = request.getParameter("cantonElejido");
		String correo = request.getParameter("correo");
		String contraseña =  request.getParameter("contraseña");
		String genero =  request.getParameter("genero");
		String fecha_nacimiento =  request.getParameter("fch-nacimiento");
		String celular = request.getParameter("celular");
		
		String tel_trabajo = request.getParameter("tel-trabajo");
		String descripcion = request.getParameter("descripcion");
		
		cientifico.setCedula(Integer.parseInt(cedula));
		cientifico.setNombre(nombre);
		cientifico.setApellido1(apellido_1);
		cientifico.setApellido2(apellido_2);
		cientifico.setContrasena(contraseña);
		cientifico.setCanton(canton);
		cientifico.setProvincia(provincia);
		cientifico.setCorreo(correo);
		cientifico.setSexo(genero);
		cientifico.setFechaNacimiento(fecha_nacimiento);
		cientifico.setDescripcion(descripcion);
		cientifico.setCelular(Integer.parseInt(celular));
		cientifico.setTelTrabajo(Integer.parseInt(tel_trabajo));
		
		try {
			controladorWeb.insertarCientifico(cientifico);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//*****************Sección Información Académica****************\\
		
		
		
		String [] titulo0 =  {request.getParameter("ult-titulo"),request.getParameter("grd-titulo"),request.getParameter("univ-titulo"),request.getParameter("pais-univ"),request.getParameter("ano-titulo")};
		
		
		if(titulo0[0] != null){
			System.out.println("entro1");
			DTO_InformacionAcademica nvaInfoAcademica  = new DTO_InformacionAcademica();
			nvaInfoAcademica.setGradoAcademico(request.getParameter("grd-titulo"));
			nvaInfoAcademica.setNombre(request.getParameter("ult-titulo"));
			nvaInfoAcademica.setUniversidad(request.getParameter("univ-titulo"));
			nvaInfoAcademica.setPais(request.getParameter("pais-univ"));
			nvaInfoAcademica.setAno(Integer.parseInt(request.getParameter("ano-titulo")));

			try {
				controladorWeb.insertarInfoAcademica(nvaInfoAcademica, cientifico.getCedula());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
		}
		
		String [] titulo1 =  {request.getParameter("titulo_1"),request.getParameter("grd-titulo_1"),request.getParameter("univ-titulo_1"),request.getParameter("pais-univ_1"),request.getParameter("ano-titulo_1")};
		
		if(titulo1[0] != null){
			System.out.println("entro2");
			DTO_InformacionAcademica nvaInfoAcademica  = new DTO_InformacionAcademica();
			nvaInfoAcademica.setGradoAcademico(request.getParameter("grd-titulo_1"));
			nvaInfoAcademica.setNombre(request.getParameter("titulo_1"));
			nvaInfoAcademica.setUniversidad(request.getParameter("univ-titulo_1"));
			nvaInfoAcademica.setPais(request.getParameter("pais-univ_1"));
			nvaInfoAcademica.setAno(Integer.parseInt(request.getParameter("ano-titulo_1")));
			try {
				controladorWeb.insertarInfoAcademica(nvaInfoAcademica, cientifico.getCedula());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
  
		}
		String [] titulo2 =  {request.getParameter("titulo_2"),request.getParameter("grd-titulo_2"),request.getParameter("univ-titulo_2"),request.getParameter("pais-univ_2"),request.getParameter("ano-titulo_2")};
		
		if(titulo2[0] != null){
			DTO_InformacionAcademica nvaInfoAcademica  = new DTO_InformacionAcademica();
			nvaInfoAcademica.setGradoAcademico(request.getParameter("grd-titulo_2"));
			nvaInfoAcademica.setNombre(request.getParameter("titulo_2"));
			nvaInfoAcademica.setUniversidad(request.getParameter("univ-titulo_2"));
			nvaInfoAcademica.setPais(request.getParameter("pais-univ_2"));
			nvaInfoAcademica.setAno(Integer.parseInt(request.getParameter("ano-titulo_2")));
			
			try {
				controladorWeb.insertarInfoAcademica(nvaInfoAcademica, cientifico.getCedula());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
  
		}
		
		String [] titulo3 =  {request.getParameter("titulo_3"),request.getParameter("grd-titulo_3"),request.getParameter("univ-titulo_3"),request.getParameter("pais-univ_3"),request.getParameter("ano-titulo_3")};

		if(titulo3[0] != null){
			DTO_InformacionAcademica nvaInfoAcademica  = new DTO_InformacionAcademica();
			nvaInfoAcademica.setGradoAcademico(request.getParameter("grd-titulo_3"));
			nvaInfoAcademica.setNombre(request.getParameter("titulo_3"));
			nvaInfoAcademica.setUniversidad(request.getParameter("univ-titulo_3"));
			nvaInfoAcademica.setPais(request.getParameter("pais-univ_3"));
			nvaInfoAcademica.setAno(Integer.parseInt(request.getParameter("ano-titulo_3")));
			
			try {
				controladorWeb.insertarInfoAcademica(nvaInfoAcademica, cientifico.getCedula());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
  
		}		
		//*****************Sección Información Profesional(Actividades)****************\\
		
		String [] actividad1 = {request.getParameter("act"),request.getParameter("area-invest"),request.getParameter("insti"),request.getParameter("depart"),request.getParameter("ano-inicio-act"),request.getParameter("pais-insti")};
				
		if(actividad1[0] != null){
			DTO_InformacionProfesional nvaInfoProfesional = new DTO_InformacionProfesional();
			nvaInfoProfesional.setActividad(request.getParameter("act"));
			nvaInfoProfesional.setAreaInvestigaciòn(request.getParameter("area-invest"));
			nvaInfoProfesional.setAnoInicio(Integer.parseInt(request.getParameter("ano-inicio-act")));
			nvaInfoProfesional.setDepartamento(request.getParameter("depart"));
			nvaInfoProfesional.setInstitucion(request.getParameter("insti"));
			nvaInfoProfesional.setPais(request.getParameter("pais-insti"));
			
			try {
				controladorWeb.insertarInfoProfesional(nvaInfoProfesional, cientifico.getCedula());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String [] actividad2 = {request.getParameter("act_1"),request.getParameter("area-invest_1"),request.getParameter("insti_1"),request.getParameter("depart_1"),request.getParameter("ano-inicio-act_1"),request.getParameter("pais-insti_1")};
		
		if(actividad2[0] != null){
			DTO_InformacionProfesional nvaInfoProfesional = new DTO_InformacionProfesional();
			nvaInfoProfesional.setActividad(request.getParameter("act_1"));
			nvaInfoProfesional.setAreaInvestigaciòn(request.getParameter("area-invest_1"));
			nvaInfoProfesional.setAnoInicio(Integer.parseInt(request.getParameter("ano-inicio-act_1")));
			nvaInfoProfesional.setDepartamento(request.getParameter("depart_1"));
			nvaInfoProfesional.setInstitucion(request.getParameter("insti_1"));
			nvaInfoProfesional.setPais(request.getParameter("pais-insti_1"));
			
			try {
				controladorWeb.insertarInfoProfesional(nvaInfoProfesional, cientifico.getCedula());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String [] actividad3 = {request.getParameter("act_2"),request.getParameter("area-invest_2"),request.getParameter("insti_2"),request.getParameter("depart_2"),request.getParameter("ano-inicio-act_2"),request.getParameter("pais-insti_2")};
		
		if(actividad3[0] != null){
			DTO_InformacionProfesional nvaInfoProfesional = new DTO_InformacionProfesional();
			nvaInfoProfesional.setActividad(request.getParameter("act_2"));
			nvaInfoProfesional.setAreaInvestigaciòn(request.getParameter("area-invest_2"));
			nvaInfoProfesional.setAnoInicio(Integer.parseInt(request.getParameter("ano-inicio-act_2")));
			nvaInfoProfesional.setDepartamento(request.getParameter("depart_2"));
			nvaInfoProfesional.setInstitucion(request.getParameter("insti_2"));
			nvaInfoProfesional.setPais(request.getParameter("pais-insti_2"));
			
			try {
				controladorWeb.insertarInfoProfesional(nvaInfoProfesional, cientifico.getCedula());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String [] actividad4 = {request.getParameter("act_3"),request.getParameter("area-invest_3"),request.getParameter("insti_3"),request.getParameter("depart_3"),request.getParameter("ano-inicio-act_3"),request.getParameter("pais-insti_3")};
		
		if(actividad4[0] != null){
			DTO_InformacionProfesional nvaInfoProfesional = new DTO_InformacionProfesional();
			nvaInfoProfesional.setActividad(request.getParameter("act_3"));
			nvaInfoProfesional.setAreaInvestigaciòn(request.getParameter("area-invest_3"));
			nvaInfoProfesional.setAnoInicio(Integer.parseInt(request.getParameter("ano-inicio-act_3")));
			nvaInfoProfesional.setDepartamento(request.getParameter("depart_3"));
			nvaInfoProfesional.setInstitucion(request.getParameter("insti_3"));
			nvaInfoProfesional.setPais(request.getParameter("pais-insti_3"));
			
			try {
				controladorWeb.insertarInfoProfesional(nvaInfoProfesional, cientifico.getCedula());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String [] actividad5 = {request.getParameter("act_4"),request.getParameter("area-invest_4"),request.getParameter("insti_4"),request.getParameter("depart_4"),request.getParameter("ano-inicio-act_4"),request.getParameter("pais-insti_4")};
		
		if(actividad5[0] != null){
			DTO_InformacionProfesional nvaInfoProfesional = new DTO_InformacionProfesional();
			nvaInfoProfesional.setActividad(request.getParameter("act_4"));
			nvaInfoProfesional.setAreaInvestigaciòn(request.getParameter("area-invest_4"));
			nvaInfoProfesional.setAnoInicio(Integer.parseInt(request.getParameter("ano-inicio-act_4")));
			nvaInfoProfesional.setDepartamento(request.getParameter("depart_4"));
			nvaInfoProfesional.setInstitucion(request.getParameter("insti_4"));
			nvaInfoProfesional.setPais(request.getParameter("pais-insti_4"));
			
			try {
				controladorWeb.insertarInfoProfesional(nvaInfoProfesional, cientifico.getCedula());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
