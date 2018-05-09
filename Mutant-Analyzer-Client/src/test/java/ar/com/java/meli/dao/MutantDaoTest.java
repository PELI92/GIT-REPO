package ar.com.java.meli.dao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import ar.com.java.meli.services.MutantService;

public class MutantDaoTest {

	@Test
	public void test() {
		MutantService ms = new MutantService();
		try {
			ms.putHuman();
			ms.putMutant();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(ms!=null);
		
	}

}
