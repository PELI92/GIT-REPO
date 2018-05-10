package ar.com.java.meli.report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import ar.com.java.meli.enums.KeysEnum;
import ar.com.java.meli.services.MutantService;

public class ReportGenerator {
	private static final String DECIMAL_FORMAT = "##########.#";
	public static Map<String, String> generarReporte(MutantService mutantService) throws SQLException {
		ResultSet rs = mutantService.getCount();
		Map<String, String> map = new HashMap<String,String>();
		while (rs.next()) {
			if (rs.getString("isMutant").equals("1")) {
				map.put(KeysEnum.MUTANT_COUNT_KEY.getValue(), rs.getString("COUNT(*)"));
			}else {
				map.put(KeysEnum.HUMAN_COUNT_KEY.getValue(), rs.getString("COUNT(*)"));
			}
		}
		Integer mutantCount = Integer.parseInt(map.get(KeysEnum.MUTANT_COUNT_KEY.getValue()));
		Integer humanCount = Integer.parseInt(map.get(KeysEnum.HUMAN_COUNT_KEY.getValue()));
		if (humanCount.equals(0)) {
			humanCount = 1;
		}
		Float ratio = (float) mutantCount/ (float)humanCount;
		map.put(KeysEnum.RATIO_KEY.getValue(), new DecimalFormat(DECIMAL_FORMAT).format(ratio));
		return map;
	}
}
