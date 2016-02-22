package javacode.util.json;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

	private static ObjectMapper mapper = new ObjectMapper();
	
	public static <T> T getObject(String json,Class<T> clazz) throws JsonParseException, JsonMappingException, IOException{
		return mapper.readValue(json, clazz);
	}
	
	public static String toJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException{
		return mapper.writeValueAsString(obj);
	}
}
