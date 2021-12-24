package currency_converter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ExchangeRateParser {

	public static Map<String, Double> parseExchangeRateJSON(String responseContent) {
		
		ObjectMapper mapper = new ObjectMapper(); 
		String dataNodeString = null; 
		
		try {
			JsonNode rootNode = mapper.readValue(responseContent, JsonNode.class);
			JsonNode dataNode = rootNode.get("data"); 
			
			dataNodeString = dataNode.toString(); 
			
		} catch (JsonParseException jpe) {
			jpe.printStackTrace();
		} catch (JsonMappingException jme) {
			jme.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		
		Map<String, Double> mapObject = null; 
		
		try {
			mapObject = mapper.readValue(dataNodeString, Map.class);
			 
		} catch (JsonParseException jpe) {
			jpe.printStackTrace();
		} catch (JsonMappingException jme) {
			jme.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		return mapObject; 
	}
}
