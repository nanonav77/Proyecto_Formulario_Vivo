package enlaceDeDatos;

public class SingletonBDMySQL_TSE {
	
	private static BDTSE_MySQL instanciaBDMySQL = null;
	
	public static synchronized BDTSE_MySQL getInstancia(){
		
		if(instanciaBDMySQL == null){
			instanciaBDMySQL = new BDTSE_MySQL();
		}
		return instanciaBDMySQL;
	}
	
	

}
