package ar.com.java.meli.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.java.meli.utils.Validator;

public class ValidatorTest {

	@Test
	public void testDnaValido() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		assertTrue(Validator.isCadenaDnaValid(dna));
	}
	@Test
	public void testDnaConEspacio() {
		String[] dna = {"ATGCGA","CAGTGC","TTAT GT","AGAAGG","CCCCTA","TCACTG"};
		assertFalse(Validator.isCadenaDnaValid(dna));
	}
	@Test
	public void testDnaNoCuadrado() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACT"};
		assertFalse(Validator.isCadenaDnaValid(dna));
	}
	@Test
	public void testDnaConBaseIncorrecta() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTQ"};
		assertFalse(Validator.isCadenaDnaValid(dna));
	}
}
