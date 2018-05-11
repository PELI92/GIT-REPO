package ar.com.java.meli.entity;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RespuestaTest {

	@Test
	public void test() {
		Map<String,String>map = new HashMap<String,String>();
		
		map.put("count_mutant_dna", "40");
		map.put("count_human_dna", "100");
		map.put("ratio", "0.4");
	
		String respuesta = Respuesta.mapToJson(map);
		assertEquals("\"ADN\": {\"count_mutant_dna\":40, \"count_human_dna\":100, \"ratio\":0.4}",respuesta);
	}

}
