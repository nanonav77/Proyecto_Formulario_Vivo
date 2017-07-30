package enlaceDeDatos;

public class SingletonBDMySQL_Cientifico {
	private static BDCientifico_MySQL instanciaBDMySQL = null;
	
	public static synchronized BDCientifico_MySQL getInstancia(){
		
		if(instanciaBDMySQL == null){
			instanciaBDMySQL = new BDCientifico_MySQL();
		}
		return instanciaBDMySQL;
	}
	
	

}
