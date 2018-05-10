package ar.com.java.meli.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import ar.com.java.meli.dao.MutantDao;
import ar.com.java.meli.utils.PropertiesUtils;

public class MutantService {

	private Properties properties = null;
	private static MutantDao mutantDao = null;
	
	
	public MutantService() throws SQLException  {
		properties = PropertiesUtils.getConfigProperties();
		
		String url2= "jdbc:mysql://google/"
				+ properties.getProperty("databaseName") 
				+ "?cloudSqlInstance="
				+ properties.getProperty("instanceConnectionName")
				+ "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user="
				+ properties.getProperty("username")
				+ "&password="
				+ properties.getProperty("password")
				+ "&useSSL=false";
		System.out.println(url2);
		Connection connection = DriverManager.getConnection(url2);
    	if (connection == null) {
    		throw new SQLException("No se pudo iniciar la conexion");
    	}
		mutantDao = new MutantDao(connection); 
	   
	}
	public void putMutant() throws SQLException {
		mutantDao.post(true);
	}
	public void putHuman() throws SQLException {
		mutantDao.post(false);
	}
	public ResultSet getCount() throws SQLException {
		return mutantDao.getCount();
	}
}
