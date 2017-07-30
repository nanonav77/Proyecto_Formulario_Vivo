package enlaceDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import dto.DTO_Persona;


public class BDTSE_MySQL
{
	private String driver = "com.mysql.jdbc.Driver";
	private String usuario = "root";
	private String contrasena = "pepe1196";
	private String servidor = "jdbc:mysql://localhost/bdtse";
	private Connection conexion; 
	
    public BDTSE_MySQL()
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

    public Connection getConexion() {
        return conexion; // Retorno el objeto Connection
    }
    
    public DTO_Persona consultarCedula(DTO_Persona pPersona){
    	try{
    		String consulta = "select cedula, nombre,apellido1, apellido2, sexo, provincia,canton from bdtse.PERSONA where cedula ="+pPersona.getCedula();
 
    		Statement consultaBD = (Statement) this.getConexion().createStatement();

    		ResultSet resultado = consultaBD.executeQuery(consulta);
        
        
    		while (resultado.next()){
    			
    			pPersona.setCedula(resultado.getInt("cedula"));
    			pPersona.setNombre(resultado.getString("nombre"));
    			pPersona.setApellido1(resultado.getString("apellido1"));
    			pPersona.setApellido2(resultado.getString("apellido2"));
    			pPersona.setSexo(resultado.getString("sexo"));
    			pPersona.setProvincia(resultado.getString("provincia"));
    			pPersona.setCanton(resultado.getString("canton"));
    			
    		}	
    		consultaBD.close();

      }
      catch (Exception e)
      {
        System.err.println("Ocurrio una excepción! ");
        System.err.println(e.getMessage());
      }
		return pPersona;
    
    }
    
 
    
} 
