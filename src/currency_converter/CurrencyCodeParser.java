package currency_converter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/** 
 * 
 * @author Pratik Pande
 * 
 * This class parses the JSON file from an API response and stores relevant informatino 
 * to a HashMap. 
 *
 */

public class CurrencyCodeParser {

	public static Map<String, String> parseCurrencyCodeJSON() {
		String responseContent = CurrencyCodeConnection.sendHttpGetRequest(); 
		
		ObjectMapper mapper = new ObjectMapper(); 
		Map<String, String> mapObject = null; 
		
		try {
			mapObject = mapper.readValue(responseContent, Map.class);
			 
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