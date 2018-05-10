package ar.com.java.meli.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	private final static String propRoot = "target/config/config.properties";
	
	public static void crearProperties() throws IOException {
		
		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream(propRoot);
			// set the config.properties value
			prop.setProperty("databaseName", "mutantAnalyzerDB");
			prop.setProperty("instanceConnectionName", "meli-203200:southamerica-east1:mutant-analyzer-db2");
			prop.setProperty("username", "root");
			prop.setProperty("password", "1234");
			// save properties to project target folder
			prop.store(output, null);

		} catch (IOException e) {
			throw new IOException("error al crear config.properties");
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					throw new IOException("No se pudo cerrar outPut");
				}
			}
		}
	}
	public static Properties getConfigProperties(){
		Properties prop = new Properties();

// la idea era subir un arhivo config.properties al servidor y obtener los datos de la BD desde ahi, pero se me complicó esa solucion asique lo dejo asi por ahora:
//		
//		FileInputStream inPut = null;
//		try {
//			inPut = new FileInputStream(propRoot);
//			prop = new Properties();
//			prop.load(inPut);
//		} catch (IOException e) {
//			throw new IOException("error al leer config.properties");
//		}finally {
//			if (inPut != null) {
//				try {
//					inPut.close();
//				} catch (IOException e) {
//					throw new IOException("No se pudo cerrar inPut");
//				}
//			}
//		}
// 
		prop.clear();
		// set the config.properties value
		prop.setProperty("databaseName", "mutantAnalyzerDB");
		prop.setProperty("instanceConnectionName", "meli-203200:southamerica-east1:mutant-analyzer-db2");
		prop.setProperty("username", "root");
		prop.setProperty("password", "1234");
			
		return prop;
	}
}