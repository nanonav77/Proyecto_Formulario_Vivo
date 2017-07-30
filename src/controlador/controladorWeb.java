package controlador;

import java.sql.SQLException;
import java.text.ParseException;

import dto.DTO_InformacionAcademica;
import dto.DTO_InformacionProfesional;
import dto.DTO_Persona;
import enlaceDeDatos.SingletonBDMySQL_Cientifico;
import enlaceDeDatos.SingletonBDMySQL_TSE;


public class controladorWeb {

	
	public static DTO_Persona obtenerDatosPorCedula(DTO_Persona pPersona){
		SingletonBDMySQL_TSE BD_TSE = new SingletonBDMySQL_TSE();
		return BD_TSE.getInstancia().consultarCedula(pPersona);

	}
	
	public static void insertarCientifico(DTO_Persona nvoCientifico) throws SQLException, ParseException{
		SingletonBDMySQL_Cientifico BD_Cientifico = new SingletonBDMySQL_Cientifico();
		BD_Cientifico.getInstancia().insertarCientifico(nvoCientifico);
	}
	
	public static void insertarInfoAcademica(DTO_InformacionAcademica nvaInformacion, int cedula) throws SQLException{
		SingletonBDMySQL_Cientifico BD_Cientifico = new SingletonBDMySQL_Cientifico();
		int id_titulo  = BD_Cientifico.getInstancia().insertarInformacionAcademica(nvaInformacion);
		BD_Cientifico.getInstancia().insertarCientificoXinfoacademica(cedula, id_titulo);
		
	}
	
	public static void insertarInfoProfesional(DTO_InformacionProfesional nvaInformacion, int cedula) throws SQLException{
		SingletonBDMySQL_Cientifico BD_Cientifico = new SingletonBDMySQL_Cientifico();
		int id_profesion  = BD_Cientifico.getInstancia().insertarInformacionProfesional(nvaInformacion);
		BD_Cientifico.getInstancia().insertarCientificoXinfoProfesional(cedula, id_profesion);
		
	}

}
