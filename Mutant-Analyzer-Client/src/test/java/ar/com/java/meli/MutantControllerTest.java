package ar.com.java.meli;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class MutantControllerTest {

	@Test
	public void test() {
		ResultSet rs = null;
		MutantController mutantController = new MutantController();
		
		if(mutantController.mutantService==null) {
			fail("fail to get service");
		}
		try {
			rs = mutantController.mutantService.getCount();
		} catch (SQLException e) {
			fail("fail to get");
		}
		if (rs==null) {
			fail("fail to get");
		}else {
			assertTrue(true);
		}
			
		
	}

}
