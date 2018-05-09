package ar.com.java.meli.analyzer;

public class MutantAnalyzer {
	
	private static final int  COINCIDENCIAS_PARA_SER_MUTANTE = 4;
	String[] ultimosCharsVerticales;
	String[] diagonalPrincipal;
	String[] diagonalSecundaria;
	int[] coincidenciasVerticales;

	
	public Boolean isMutant(String[] dna) {	
		
		coincidenciasVerticales = new int[dna.length];
		ultimosCharsVerticales = new String[dna.length];
		diagonalPrincipal = new String[dna.length*2-1];
		diagonalSecundaria = new String[dna.length*2-1];
		
		for(int i=0; i<dna.length;i++) {
			if (isMutantHorizon(dna[i],i)) {
				return true;
			}
		}
		for(int k=3;k<dna.length*2-2;k++) {
			if (isMutantCadenaString(diagonalPrincipal[k])){
				return true;
			}
			if (isMutantCadenaString(diagonalSecundaria[k])){
				return true;
			}
		}
		return false;
	}
	
	private  Boolean isMutantCadenaString(String string) {
		String ultimoCharLeido = null;
		int coincidencias = 0;
		String[] charArray = string.split(""); 
		for (int j=0;j<charArray.length;j++) {
			if(ultimoCharLeido==null) {
				coincidencias++;
			}else {
				if (ultimoCharLeido.equals(charArray[j])) {
					coincidencias++;
				}else {
					coincidencias=1;
				}
			}
			if (coincidencias == COINCIDENCIAS_PARA_SER_MUTANTE) {
				return true;
			}
			ultimoCharLeido = charArray[j];
		}
		return false;
	}
	
	private  Boolean isMutantHorizon(String string,int i) {
		String ultimoCharLeido = null;
		int coincidencias = 0;
		String[] charArray = string.split(""); 
		
		for (int j=0;j<charArray.length;j++) {
			if(ultimoCharLeido==null) {
				coincidencias++;
			}else {
				if (ultimoCharLeido.equals(charArray[j])) {
					coincidencias++;
					if (coincidencias == COINCIDENCIAS_PARA_SER_MUTANTE) {
						return true;
					}
				}else {
					coincidencias=1;
				}
			}
			if(ultimosCharsVerticales[j]==null) {
				ultimosCharsVerticales[j]=charArray[j];
			}else {
				if (ultimosCharsVerticales[j].equals(charArray[j])) {
					coincidenciasVerticales[i]++;
					if (coincidenciasVerticales[i] == COINCIDENCIAS_PARA_SER_MUTANTE) {
						return true;
					}
				}else {
					coincidenciasVerticales[i]=1;
				}
			}

			utltimoCharDiagonales(charArray,i,j); 
			ultimosCharsVerticales[j] = charArray[j];
			ultimoCharLeido = charArray[j];
		}
		return false;
	}

	private  void utltimoCharDiagonales(String[] charArray,int i,int j) {
		if(this.diagonalPrincipal[j+i]==null) {
			this.diagonalPrincipal[j+i]=charArray[j];
		}else {
			this.diagonalPrincipal[j+i]+=charArray[j];
		}
		if(this.diagonalSecundaria[j-i+charArray.length-1]==null) {
			this.diagonalSecundaria[j-i+charArray.length-1]=charArray[j];
		}else {
			this.diagonalSecundaria[j-i+charArray.length-1]+=charArray[j];
		}
	}
}
