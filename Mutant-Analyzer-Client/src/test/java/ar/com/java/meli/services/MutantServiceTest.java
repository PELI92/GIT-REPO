package ar.com.java.meli.services;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

public class MutantServiceTest {
	
	MutantService ms = null;
	
	@Test
	public void test() throws SQLException {
		MutantService ms = null;
		ms = new MutantService();
		assertTrue(ms!=null);
		
	}

}
