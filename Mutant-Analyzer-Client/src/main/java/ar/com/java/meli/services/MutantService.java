package ar.com.java.meli.services;

import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.java.meli.dao.MutantDao;

public class MutantService {
	
	private static final String databaseName = "mutantAnalyzerDB";
	private static final String instanceConnectionName = "meli-203200:southamerica-east1:mutant-analyzer-db2";
	private static final String username = "root";
	private static final String password = "peli92";
	private MutantDao mutantDao;
	
	public MutantService()  {
//		String url = System.getProperty("cloudsql");
		try {
		    String jdbcUrl = String.format(
		            "jdbc:mysql://google/%s?cloudSqlInstance=%s"
		                + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
		            databaseName,
		            instanceConnectionName);
		    
		    
		    mutantDao = new MutantDao(DriverManager.getConnection(jdbcUrl, username, password));
//			mutantDao = new MutantDao(DriverManager.getConnection(url));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	public void putMutant() throws SQLException {
		mutantDao.post(true);
	}
	public void putHuman() throws SQLException {
		mutantDao.post(false);
	}
}
