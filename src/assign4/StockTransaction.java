package assign4;

import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class StockTransaction {

	public static void main(String[] args) {
		// CapitalGains gains = new
		// CapitalGains("C:/Users/Daniel/Documents/Stocks.txt","C:/Users/Daniel/Documents/Transactions.txt");
		CapitalGains gains = new CapitalGains("src/Stocks.txt",/*put the file path here if not using the one in your project*/"src/Transactions.txt");
		Scanner input = new Scanner(System.in);
		String[] testCases = {"aapl","fb","IBM","XYz","sbux","ko"};
		for(int i = 0; i < 6; i++) {
			System.out.println("Test: " + i);
			System.out.println("Enter the Symbol for your desired stock");
			String comp = testCases[i].toUpperCase();//input.nextLine().toUpperCase();
			System.out.println("User Input: " + comp);

			try {
				System.out.println("Your capital gain for " + comp + " is: $" + gains.getCapitalGain(comp));
			} catch (InvalidSale e) {
				System.out.println("Sales exceeded quantity bought");
			} catch (FileNotFoundException e) {
				System.out.println("Input files not found");
			} catch (InvalidParameterException e) {
				System.out.println("Invalid company name");
			}
			System.out.println();
		}
	}
}
