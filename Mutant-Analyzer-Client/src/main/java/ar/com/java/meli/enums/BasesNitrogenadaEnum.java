package ar.com.java.meli.enums;

public enum BasesNitrogenadaEnum {
	
	ADENINA("A"), GUANINA("G"), CITOSINA("C"), TIMINA("T");
	
	private char value;
	
	BasesNitrogenadaEnum(String value){
		this.value = value.toCharArray()[0];
	}
	
	public char getValue(){
		return this.value;
	}
	
	static public Boolean isValidBase(char base) {
		for (BasesNitrogenadaEnum validBase : BasesNitrogenadaEnum.values()) {
			if (validBase.getValue() == base) {
				return true;
			}
		}
		return false;
	}
}
