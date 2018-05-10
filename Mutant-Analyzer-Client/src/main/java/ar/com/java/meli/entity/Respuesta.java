package ar.com.java.meli.entity;

import java.util.Map;

import ar.com.java.meli.enums.KeysEnum;

/**
 * Se Mapea la respuesta de la API
 * en donde devolvera un String de la misma y se formateara a JSON desde el controlador
 */
public class Respuesta {

    public static String mapToJson(Map<String, String> map) {
        return "ADN: {“" +
        		KeysEnum.MUTANT_COUNT_KEY.getValue() + "”:" + map.get(KeysEnum.MUTANT_COUNT_KEY.getValue()) + ", “"+
        		KeysEnum.HUMAN_COUNT_KEY.getValue() + "”:" + map.get(KeysEnum.HUMAN_COUNT_KEY.getValue()) + ", “"+
                KeysEnum.RATIO_KEY.getValue() + "”:" +  map.get(KeysEnum.RATIO_KEY.getValue()) + "}";
    }
}
