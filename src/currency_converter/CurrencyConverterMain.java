package currency_converter;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.text.DecimalFormat;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author Pratik Pande
 * 
 * This class contains the main functinality of the currency converter application through the implemenation
 * of several supportive classes. It is currently hosts text-based interaction only, which will be updated to
 * support a GUI in the future.
 *
 */

public class CurrencyConverterMain {
	
	static String fromCode; 
	static String toCode; 
	static double amount; 
	
	public static void main(String[] args) {
				
		Map<String, String> currencyCodeMap = null;
		
		CurrencyCodeConnection.sendHttpGetRequest(); // Establishing connection to currency code API
		currencyCodeMap = JSONToMap.parseCurrencyCodeJSON(); // Storing contents of currency code API response (JSON) into a HashMap
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the currency converter beta. (This application is currently in development)"); 
		
		// Checking validity of user input: 
		
		while(true) {
			System.out.println("Enter the 3-letter currency code (i.e USD) that you would like to convert from: "); 
			try {
				fromCode = sc.nextLine().trim().toUpperCase(); 
				if(!currencyCodeMap.containsKey(fromCode)) {
					System.out.println("That is an invalid currency, or currency conversion is not yet supported for this currency."); 
					System.out.println("Please try again."); 
				} else {
					break; // This loop only breaks if the user enters a valid currency code
				}
			} catch (InputMismatchException ime) {
				ime.printStackTrace();
			}
		}
		
		while(true) {
			System.out.println("Enter the 3-letter currency code (i.e USD) that you would like to convert to: "); 
			try {
				toCode = sc.nextLine().trim().toUpperCase(); 
				if(!currencyCodeMap.containsKey(toCode)) {
					System.out.println("That is an invalid currency, or currency conversion is not yet supported for this currency."); 
					System.out.println("Please try again."); 
				} else {
					break; // This loop only breaks if the user enters a valid currency code
				}
			} catch (InputMismatchException ime) {
				ime.printStackTrace();
			}
		}
		
		while(true) {
			System.out.println("Enter the amount of funds (i.e 100.00 or 1.25) you would like to convert: "); 
			try {
				amount = Double.parseDouble(sc.next()); 
				if(amount < 0 ) {
					System.out.println("The entered value was an invalid amount."); 
					continue; 
				} else {
					break; // This loop only breaks when a user has entered a valid double value
				}
	    	} catch (NumberFormatException nfe) {
	    			System.out.println("Invalid input (nfe)");
	    	}
		}
		
		String responseContent = ExchangeRateConnection.sendHttpGetRequest(); 
		Map<String, Double> mapObject = ExchangeRateParser.parseExchangeRateJSON(responseContent); 
				
		double exchangeRate = mapObject.get(toCode); 
		double funds = exchangeRate * amount; 
		
		DecimalFormat df = new DecimalFormat("###.###"); 
		
		System.out.println(fromCode + " " + df.format(amount) + " is " + toCode + " " + df.format(funds)); 
		System.exit(0);
	}
 }