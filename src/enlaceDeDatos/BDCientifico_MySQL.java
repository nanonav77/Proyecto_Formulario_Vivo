package enlaceDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.PreparedStatement;

import dto.DTO_InformacionAcademica;
import dto.DTO_InformacionProfesional;
import dto.DTO_Persona;

public class BDCientifico_MySQL {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String usuario = "root";
	private String contrasena = "pepe1196";
	private String servidor = "jdbc:mysql://localhost/Cientifico";
	private Connection conexion; 
	
    public BDCientifico_MySQL()
    {
        try {
            // Cargar drivers de MySQL
            Class.forName(driver);

            // Establecer la conexion con la base de datos
            conexion = DriverManager.getConnection(servidor , usuario, contrasena);

            System.out.println("Conexión realizada a la base de datos con éxito.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error!, conexión fallida a la base de datos.");
        }
    }
    
    public void abrirConexion(){
        try {
            // Cargar drivers de MySQL
            Class.forName(driver);

            // Establecer la conexion con la base de datos
            conexion = DriverManager.getConnection(servidor , usuario, contrasena);

            System.out.println("Conexión realizada a la base de datos con éxito.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error!, conexión fallida a la base de datos.");
        }    	
    }

    public Connection getConexion() {
        return conexion; // Retorno el objeto Connection
    }
    
    public int insertarCientifico(DTO_Persona nvoCientifico) throws SQLException, ParseException{
    	
    	      abrirConexion();
              String query = " insert into Cientifico.cientifico (cedula, nombre, apellido1, apellido2, fecha_nacimiento, sexo, provincia, canton, correo, contrasena, celular,teltrabajo, orcid, descripcion)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

              
              PreparedStatement insert = (PreparedStatement) getConexion().prepareStatement(query);
              insert.setInt(1, nvoCientifico.getCedula());
              insert.setString (2, nvoCientifico.getNombre());
              insert.setString (3, nvoCientifico.getApellido1());
              insert.setString (4, nvoCientifico.getApellido2());
              java.util.Date formato =  new SimpleDateFormat("dd/MM/yyyy").parse(nvoCientifico.getFechaNacimiento());
              //Date fechaNacimiento = (Date) formato.parse( nvoCientifico.getFechaNacimiento() ) ; 
              java.sql.Date sqlDate = new java.sql.Date(formato.getTime());
              insert.setDate(5, sqlDate);
              insert.setString (6, nvoCientifico.getSexo());
              insert.setString (7, nvoCientifico.getProvincia());
              insert.setString (8, nvoCientifico.getCanton());
              insert.setString (9, nvoCientifico.getCorreo());
              insert.setString (10, nvoCientifico.getContrasena());
              insert.setInt (11, nvoCientifico.getCelular());
              insert.setInt (12, nvoCientifico.getTelTrabajo());
              insert.setString (13, nvoCientifico.getOrcid());
              insert.setString (14, nvoCientifico.getDescripcion());
              
              insert.execute();
              

              
              conexion.close();

              
              return nvoCientifico.getCedula();

    }
    
    public int insertarInformacionAcademica(DTO_InformacionAcademica pInformacion) throws SQLException{
    	
    	
    	abrirConexion();
    	String query = "insert into Cientifico.informacion_academica(grado,universidad,ano,pais,nombre) values(?,?,?,?,?)"; 
    	PreparedStatement insert = (PreparedStatement) getConexion().prepareStatement(query);
    	
    	
    	insert.setString(1, pInformacion.getGradoAcademico());
    	insert.setString(2, pInformacion.getUniversidad());
    	insert.setInt(3, pInformacion.getAno());
    	insert.setString(4, pInformacion.getPais());
    	insert.setString(5, pInformacion.getNombre());
    	
        insert.execute();
        int id = (int) insert.getLastInsertID();
        
        conexion.close();

        return id;
    	
    }
    
    public void insertarCientificoXinfoacademica(int cedula, int id_titulo) throws SQLException{
    	
    	abrirConexion();
    	String query = "insert into Cientifico.cientifico_x_infoacademica (cedula, id_titulo) values(?,?)";
    	PreparedStatement insert = (PreparedStatement) getConexion().prepareStatement(query);
    	
    	insert.setInt(1, cedula);
    	insert.setInt(2, id_titulo);
    	
        insert.execute();
        conexion.close(); 
    }
    
    public int insertarInformacionProfesional(DTO_InformacionProfesional pInformacion) throws SQLException{
    	
    	abrirConexion();
    	String query = "insert into Cientifico.informacion_profesional(actividad,areainvestigacion,institucion,departamento,anoinicio,pais)values(?,?,?,?,?,?)";
    	PreparedStatement insert = (PreparedStatement) getConexion().prepareStatement(query);
    	
    	insert.setString(1, pInformacion.getActividad());
    	insert.setString(2, pInformacion.getAreaInvestigaciòn());
    	insert.setString(3, pInformacion.getInstitucion());
    	insert.setString(4, pInformacion.getDepartamento());
    	insert.setInt(5, pInformacion.getAnoInicio());
    	insert.setString(6, pInformacion.getPais());
        insert.execute();
        int id = (int) insert.getLastInsertID();
        conexion.close(); 
    	return id;
    }
    
    public void insertarCientificoXinfoProfesional(int cedula, int id_profesion) throws SQLException{
    	abrirConexion();
    	String query = "insert into Cientifico.cientifico_x_infoprofesional (cedula, id_profesion) values(?,?)";
    	PreparedStatement insert = (PreparedStatement) getConexion().prepareStatement(query);
    	
    	insert.setInt(1, cedula);
    	insert.setInt(2, id_profesion);
    	
        insert.execute();
        conexion.close(); 
    }
    	

}
