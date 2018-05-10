package ar.com.java.meli.enums;

public enum KeysEnum {
	
	MUTANT_COUNT_KEY("count_mutant_dna"), HUMAN_COUNT_KEY("count_human_dna"), RATIO_KEY("ratio");
	
	private String value;
	
	KeysEnum(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}
