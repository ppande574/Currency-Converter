package currency_converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pratik Pande
 * 
 * This class has the functionality to read from a CSV file and store the data it contains into a HashMap. 
 * 
 */

public class FileParser {
	
	public static HashMap<Integer, String> parseFile() {
				
		HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>(); 
		File f = new File("Data/topCurrencies.csv"); 
		Scanner sc; 
		
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException fnfe) {
			throw new RuntimeException(fnfe); 
		} 
		
		sc.nextLine(); 
		while(sc.hasNext()) {
			String line = sc.nextLine(); 
			if(!line.trim().isEmpty()) {
				String tokens[] = line.split(","); 
				String num = tokens[0]; 
				String currencyTag = tokens[1]; 
				
				int currencyRank = Integer.parseInt(num); 
				
				// Storing parsed data in HashMap: 
				
				currencyCodes.put(currencyRank, currencyTag); 
			}
		}
		
		sc.close();
		return currencyCodes; 
	}
}