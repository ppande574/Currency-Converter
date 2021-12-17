package currency_converter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ConversionRateParser {

	public static Map<String, String> parseExchangeRateJSON() {
		String responseContent = CurrencyCodeConnection.sendHttpGetRequest(); 
		
		ObjectMapper mapper = new ObjectMapper(); 
		Map<String, String> mapObject = null; 
		
		try {
			mapObject = mapper.readValue(responseContent, Map.class);
			
			 for (Map.Entry<String, String> entry : mapObject.entrySet()) {
				 System.out.println(entry.getKey() + "." + entry.getValue()); 
			 }
			 
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
