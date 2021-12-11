package currency_converter;

import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

	public static void main(String[] args) {
		
		String fromCode; 
		String toCode; 
		
		double amount; 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the currency converter. (This application is currently in its development phase.)\n"); 
		
		System.out.println("Enter the currency code (3 letters, i.e USD) you would like to convert from: \n");
		
		fromCode = sc.nextLine(); 
		fromCode.toUpperCase(); 
		
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
			toCode = sc.nextLine().trim(); 
			toCode.toUpperCase(); 
			
			if(!(currencyMap.containsValue(toCode))) {
				// System.out.println("The code you entered is: " + fromCode + " and it is of type: " + fromCode.getClass()); 
				System.out.println("\nCurrency conversion is not yet supported for this currency."); 
				System.exit(0); 
			}
			
			System.out.println("Enter the amount of funds (i.e 100.00 or 1.25) you would like to convert: "); 
			amount = sc.nextFloat(); 
			
			if(amount < 0 ) {
				System.out.println("\n The entered value was an invalid amount."); 
				System.exit(0);
			}
			
		}		
	}
}
