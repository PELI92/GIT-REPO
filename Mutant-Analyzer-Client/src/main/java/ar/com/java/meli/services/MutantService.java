package ar.com.java.meli.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.java.meli.dao.MutantDao;

public class MutantService {
	
	private static final String databaseName = "mutantAnalyzerDB";
	private static final String instanceConnectionName = "meli-203200:southamerica-east1:mutant-analyzer-db2";
	private static final String username = "peli";
	private static final String password = "";
	private static MutantDao mutantDao;
	
	
	public MutantService()  {
		String jdbcUrl = String.format(
			    "jdbc:mysql://google/%s?cloudSqlInstance=%s&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
			    databaseName,
			    instanceConnectionName);
	    try {
	    	Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			mutantDao = new MutantDao(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
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
