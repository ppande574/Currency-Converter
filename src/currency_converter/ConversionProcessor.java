package currency_converter;

import java.io.BufferedReader;
import java.io.IOException;
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

public class ConversionProcessor {
	
	private static HttpURLConnection connection; 
	
	// CURRENT APPLICATION ID DOES NOT SUPPORT SINGLE CURRENCY CONVERSION
	// API FUNCTIONALITY-- NEED TO FIND ANOTHER API
	
	public static StringBuffer sendHttpGetRequest() {
		
		StringBuffer sb = new StringBuffer(); 
		
		// TODO: 
		
		return sb; 
	}	
}