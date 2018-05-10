package ar.com.java.meli.services;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.servlet.ServletException;

import org.junit.Test;

public class MutantServiceTest {

	@Test
	public void test() {
		MutantService ms = null;
		ms = new MutantService();
		assertTrue(ms!=null);
		
	}

}
