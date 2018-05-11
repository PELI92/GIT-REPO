package ar.com.java.meli.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import ar.com.java.meli.utils.PropertiesUtils;

public abstract class AbstractService {
	
	private Properties properties = null;
	protected Connection connection = null;
	
	public AbstractService() throws SQLException {
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
		connection = DriverManager.getConnection(url2);
		if (connection == null) {
			throw new SQLException("No se pudo iniciar la conexion");
		}
	}

}
