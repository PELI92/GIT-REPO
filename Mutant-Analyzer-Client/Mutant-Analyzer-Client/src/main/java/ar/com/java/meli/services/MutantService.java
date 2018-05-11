package ar.com.java.meli.services;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.java.meli.dao.MutantDao;

public class MutantService extends AbstractService {

	private static MutantDao mutantDao = null;
	
	public MutantService()  throws SQLException  {
		init();
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
