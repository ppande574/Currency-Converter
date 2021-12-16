package currency_converter;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Pratik Pande
 * 
 * This class contains the main functinality of the currency converter application through the implemenation
 * of several supportive classes. It is currently hosts text-based interaction only, which will be updated to
 * support a GUI in the future.
 *
 */


public class CurrencyConverter {
	
	static String fromCode; 
	static String toCode; 
	
	static double amount; 
	
	public static void main(String[] args) {
		
		CurrencyCodeProcessor.sendHttpGetRequest(); 		
		Scanner sc = new Scanner(System.in);
		
		// CurrencyCodeProcessor.sendHttpGetRequest();
		
		System.out.println("Welcome to the currency converter. (This application is currently in its development phase.)\n"); 
		System.out.println("Enter the currency code (3 letters, i.e USD) you would like to convert from: ");
	
		fromCode = sc.nextLine().trim().toUpperCase(); 
		
		// Checking validity of user input: 
		
		HashMap<Integer, String> currencyMap = FileParser.parseFile(); // Using the File Parsing class method to retrieve HashMap
	
		if(!(currencyMap.containsValue(fromCode))) {
			System.out.println("\nCurrency conversion is not yet supported for this currency."); 
			System.exit(0); 
		} 
		else {
			System.out.println("Enter the currency code (3 letters, i.e USD) you would like to convert to: "); 
			toCode = sc.nextLine().trim().toUpperCase(); 
			
			if(!(currencyMap.containsValue(toCode))) {
				System.out.println("\nCurrency conversion is not yet supported for this currency."); 
				System.exit(0); 
			}
			
			System.out.println("Enter the amount of funds (i.e 100.00 or 1.25) you would like to convert: "); 
			amount = sc.nextFloat(); 
			
			double currencyQuantity = 0; 
		
			while(true) {
				currencyQuantity = 0; 
				System.out.println("Enter the amount of funds (i.e 100.00 or 1.25) you would like to convert: "); 
				try {
					amount = Double.parseDouble(sc.next()); 
					currencyQuantity += amount; // Using variable with higher scope to hold value so that it can be used outside of "while" loop
					if(currencyQuantity < 0 ) {
						System.out.println("The entered value was an invalid amount."); 
						continue; 
					} else {
				        break; // This loop only breaks when a user has entered a valid double value
					}
			    } catch (NumberFormatException nfe) {
					System.out.println("Invalid input (nfe)");
			    }
			}
		}
	}	
 }