package ar.com.java.meli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MutantDao {
	Connection connection;
	public MutantDao(Connection connection) {
		this.connection = connection;
	}
	public void post(Boolean isMutant) throws SQLException{
	
		final String insertSql = "INSERT INTO mutants (isMutant,date) VALUES (?,CURDATE());";
		try (PreparedStatement statementInsertSql = connection.prepareStatement(insertSql)) {
			if(isMutant) {
				statementInsertSql.setString(1,"1");
			}else {
				statementInsertSql.setString(1,"0");
			}
			statementInsertSql.executeUpdate();
		}
	}
}
