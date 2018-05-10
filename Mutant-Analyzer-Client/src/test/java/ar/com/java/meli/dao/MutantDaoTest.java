package ar.com.java.meli.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import ar.com.java.meli.services.MutantService;
import ar.com.java.meli.utils.PropertiesUtils;

public class MutantDaoTest {
	
	MutantService ms = null;
	public MutantDaoTest() throws SQLException{
		ms =  new MutantService();
	}

	@Test
	public void test() {
		try {
			ms.putHuman();
			ms.putMutant();

		} catch (SQLException e) {
			fail("no se pudo realizar el put");
			e.printStackTrace();
		}
		assertTrue(ms!=null);
		
	}
	@Test
	public void testPut() throws SQLException {
		ResultSet rs = null;
		
		String humanos= null;
		String mutantes= null;
		
		try {
			rs = ms.getCount();

		} catch (SQLException e) {
			fail("no se pudo realizar el get");
			e.printStackTrace();
		}
		
		while (rs.next()) {
			if (rs.getString("isMutant").equals("1")) {
				mutantes = rs.getString("COUNT(*)");
			}else {
				humanos = rs.getString("COUNT(*)");
			}
		}
		assertTrue(mutantes !=null);
		assertTrue(humanos !=null);
		
	}

}
