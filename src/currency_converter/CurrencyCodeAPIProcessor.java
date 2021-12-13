package currency_converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.io.InputStreamReader;

import javax.net.ssl.HttpsURLConnection;

/**
 * 
 * @author Pratik Pande
 * 
 * This class includes funcionality to connect to an API that returns a JSON response. 
 * The file is then parsed, and currency codes are stored for later reference. 
 */

public class CurrencyCodeAPIProcessor {

	public static void sendHttpGetRequest() throws MalformedURLException {
				
		String GET_URL = "https://openexchangerates.org/api/currencies.json"; 
		
		URL url = new URL(GET_URL); 
		
		try {
			HttpsURLConnection httpsURLconnection = (HttpsURLConnection) url.openConnection();
			httpsURLconnection.setRequestMethod("GET"); 
			int responseCode = httpsURLconnection.getResponseCode(); 
			
			if(responseCode == HttpsURLConnection.HTTP_OK){
				BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLconnection.getInputStream())); 
			}
	
		} catch (IOException ioe) {
			System.out.println("IO exception (IOE)"); 
		} 
	}
	
	
	public static HashMap<Integer, String> parseJson() {
		HashMap<Integer, String> result = new HashMap<Integer, String>(); 
		
		
		
		return result; 
	}
	
}
