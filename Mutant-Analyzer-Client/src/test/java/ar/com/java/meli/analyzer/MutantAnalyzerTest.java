package ar.com.java.meli.analyzer;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.java.meli.analyzer.MutantAnalyzer;

public class MutantAnalyzerTest {

	@Test
	public void testMutanteVertical() {
		MutantAnalyzer ma = new MutantAnalyzer();
		String[] dna = {
				"ATGCGA",
				"CAGTGC",
				"TTCTGT",
				"AGAAGG",
				"CCTCTA",
				"TCACTG"};
		for(int i=0;i<1;i++) {
			assertTrue(ma.isMutant(dna));
		}
	}
	@Test
	public void testMutantHorizontal() {
		MutantAnalyzer ma = new MutantAnalyzer();
		String[] dna = {
				"ATGCGA",
				"CAGTGC",
				"TTGTAT",
				"AGAAGG",
				"CCCCTA", 
				"TCACTG"};
		for(int i=0;i<1;i++) {
			assertTrue(ma.isMutant(dna));
		}
	}
	@Test
	public void testMutantDiagonal() {
		MutantAnalyzer ma = new MutantAnalyzer();
		String[] dna = {
				"ATGCGA",
				"CAGTGC",
				"TTATAT",
				"AGAAGG",
				"CTCCTA", 
				"TCACTG"};
		for(int i=0;i<1;i++) {
			assertTrue(ma.isMutant(dna));
		}
	}
	@Test
	public void testMutantDiagonalSecundaria() {
		MutantAnalyzer ma = new MutantAnalyzer();
		String[] dna = {
				"ATGCGA",
				"CAGTGC",
				"TTCTAT",
				"AGAATG",
				"CTCTGA", 
				"TCTCTG"};
		for(int i=0;i<1;i++) {
			assertTrue(ma.isMutant(dna));
		}
	}
	@Test
	public void testHuman() {
		MutantAnalyzer ma = new MutantAnalyzer();
		String[] dna = {
				"ATGCGA",
				"CAGTGC",
				"TTGTAT",
				"AGAAGG",
				"CTCCTA", 
				"TCACTG"};
		for(int i=0;i<1;i++) {
			assertFalse(ma.isMutant(dna));
		}
	}
}
