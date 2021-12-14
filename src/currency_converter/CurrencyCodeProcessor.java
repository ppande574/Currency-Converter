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

public class CurrencyCodeProcessor {
	
	private static HttpURLConnection connection; 

	public static void sendHttpGetRequest() {
		
		BufferedReader reader; 
		String line; 
		StringBuffer responseContent = new StringBuffer(); 
		
		
		try {
			URL url = new URL("https://openexchangerates.org/api/currencies.json"); 
			connection = (HttpURLConnection) url.openConnection(); 
			
			// Request Setup: 
			
			connection.setRequestMethod("GET"); 
			connection.setConnectTimeout(7000); // If connection is not successsful after 7 seconds, timeout
			connection.setReadTimeout(7000); 
			
			int status = connection.getResponseCode(); 
			//System.out.println("Response code is: " + status); 
			
			// Handling unsuccessful status: 
			
			if(status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream())); 
				while((line = reader.readLine()) != null) {
					responseContent.append(line); 
				}
				reader.close(); 
			} 
			
			// Handling successful status: 
			
			else {												
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
				while((line = reader.readLine()) != null) {
					responseContent.append(line); 
				}
				reader.close(); 
			}
			
			System.out.println(responseContent); 
			
		} catch(MalformedURLException mue) {
			mue.printStackTrace(); 
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			connection.disconnect(); // Closing connection at the end
		}
		
	}
	
	
	public static HashMap<Integer, String> parseJson() {
		HashMap<Integer, String> result = new HashMap<Integer, String>(); 
		
		
		return result; 
	}
	
}
