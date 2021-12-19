package currency_converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @author Pratik Pande
 * 
 * This class includes functionality to connect to an API that returns a response 
 * containing currency exchange rates between two given currencies. 
 *
 */

public class ExchangeRateConnection {
	
	private static HttpURLConnection connection; 
	
	public static String sendHttpGetRequest() {
		
		BufferedReader reader; 
		String line = null; 
		StringBuffer responseContent = new StringBuffer(); 
		
		String apiKey = "96a912e0-5eab-11ec-b544-55495b68723e"; // 50000/month - 4500/hr - Renews 01/16/2022
		
		try {
			URL url = new URL("https://freecurrencyapi.net/api/v2/latest?apikey=" + apiKey + "&base_currency=" + CurrencyConverterMain.fromCode);
			connection = (HttpURLConnection) url.openConnection(); 
			
			// Request Setup: 
			
			connection.setRequestMethod("GET"); 
			connection.setConnectTimeout(7000); 
			connection.setReadTimeout(7000); 
			
			int status = connection.getResponseCode(); 
			// System.out.println("Response Code is: " + status); 
			
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
			//System.out.println(responseContent); 
			
		} catch (MalformedURLException mue) {
			// TODO Auto-generated catch block
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace(); 
		} finally {
			connection.disconnect(); 
		}
		
		String conversionStringJSON = responseContent.toString(); 
		return conversionStringJSON; 
	}	
}