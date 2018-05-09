package ar.com.java.meli.utils;

import ar.com.java.meli.enums.BasesNitrogenadaEnum;

public class Validator {
	

	static public Boolean isCadenaDnaValid(String[] cadenaDna) {
		
		Boolean result = true;
		
		for (String cadena : cadenaDna) {
			// valido que el ADN sea cuadrado
			if (cadenaDna.length!=(cadena.length())){
				result = false;
			}
			// valido que el contenido de cada cadena sea valido
			for (char base : cadena.toCharArray()) {
				if (!BasesNitrogenadaEnum.isValidBase(base))
					result =false;
			}
		}			
		return result;
	}
	
	
}
