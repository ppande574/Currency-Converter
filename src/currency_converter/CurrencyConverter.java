package currency_converter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
	

	public static void main(String[] args) {
		

		String fromCode; 
		String toCode; 
		
		double amount; 
		Scanner sc = new Scanner(System.in);
		
		// CurrencyCodeProcessor.sendHttpGetRequest();
		
		
		System.out.println("Welcome to the currency converter. (This application is currently in its development phase.)\n"); 
		
		System.out.println("Enter the currency code (3 letters, i.e USD) you would like to convert from: ");
		
		fromCode = sc.nextLine().trim().toUpperCase(); 
		
		// Checking validity of user input: 
		
		if(fromCode.length() != 3 || fromCode == null) {
			System.out.println("\nThat is an invalid currency code."); 
			System.exit(0);
		}
		
		// System.out.println("The code you entered is: " + fromCode + " and it is of type: " + fromCode.getClass()); 
		
		// System.out.println("Code is: " + fromCode); 
		
		HashMap<Integer, String> currencyMap = FileParser.parseFile(); // Using the File Parsing class method to retrieve HashMap
	
		// System.out.println(currencyMap); 
	
		if(!(currencyMap.containsValue(fromCode))) {
			// System.out.println("The code you entered is: " + fromCode + " and it is of type: " + fromCode.getClass()); 
			System.out.println("\nCurrency conversion is not yet supported for this currency."); 
			System.exit(0); 
		} 
		else {
			System.out.println("Enter the currency code (3 letters, i.e USD) you would like to convert to: "); 
			toCode = sc.nextLine().trim().toUpperCase(); 
			
			if(!(currencyMap.containsValue(toCode))) {
				// System.out.println("The code you entered is: " + fromCode + " and it is of type: " + fromCode.getClass()); 
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
						// System.out.println("The amount you entered is: " + currencyQuantity + " " + fromCode); 
				        break; // This loop only breaks when a user has entered a valid double value
					}
			    } catch (NumberFormatException nfe) {
					System.out.println("Invalid input (nfe)");
			    }
			}
			
		}
	}	
 }
	

		


