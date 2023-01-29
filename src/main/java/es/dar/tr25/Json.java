package es.dar.tr25;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
	private static ObjectMapper mapper;
	
	public static ObjectMapper mapper() {
		if(Json.mapper == null) {
			Json.mapper = Json.createJson();
		}
		return Json.mapper;
	}
	
	private static ObjectMapper createJson() {
		return new ObjectMapper();
	}
}
