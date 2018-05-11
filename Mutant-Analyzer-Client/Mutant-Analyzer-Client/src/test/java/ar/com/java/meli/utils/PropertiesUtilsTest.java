package ar.com.java.meli.utils;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class PropertiesUtilsTest {

	@Test
	public void test() throws IOException {
		Properties prop = PropertiesUtils.getConfigProperties();
		assertTrue("mutantAnalyzerDB".equals(prop.getProperty("databaseName")));
		assertTrue("meli-203200:southamerica-east1:mutant-analyzer-db2".equals(prop.getProperty("instanceConnectionName")));
		assertTrue("root".equals(prop.getProperty("username")));
		assertTrue("1234".equals(prop.getProperty("password")));
	}
	@Test
	public void test2() throws IOException {
		PropertiesUtils.crearProperties();
		Properties prop = PropertiesUtils.getConfigProperties();
		assertTrue("mutantAnalyzerDB".equals(prop.getProperty("databaseName")));
		assertTrue("meli-203200:southamerica-east1:mutant-analyzer-db2".equals(prop.getProperty("instanceConnectionName")));
		assertTrue("root".equals(prop.getProperty("username")));
		assertTrue("1234".equals(prop.getProperty("password")));
	}

}
