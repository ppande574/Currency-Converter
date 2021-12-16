package currency_converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.io.InputStreamReader;
import javax.net.ssl.HttpsURLConnection;

/**
 * 
 * @author Pratik Pande
 * 
 * This class serves the purpose of connecting to an API that responds with a JSON
 * listing all globally used currencies and returns the response in the form of a string. 
 */

public class CurrencyCodeProcessor {
	
	private static HttpURLConnection connection; 

	public static String sendHttpGetRequest() {
		
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
			
			// System.out.println(responseContent); 
			
		} catch(MalformedURLException mue) {
			mue.printStackTrace(); 
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			connection.disconnect(); // Closing connection at the end
		}
		
		String responseStringJSON = responseContent.toString(); // Converting StringBuffer to a string
		
		return responseStringJSON; 
	}
}