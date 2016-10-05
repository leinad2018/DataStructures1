package doublelinked;

import java.io.File;
import java.util.Scanner;

public class CapitalGains {
	private DList<String> transactions;
	private String companies;

	public CapitalGains(String stocksFilePath, String transFilePath) throws Exception {
		getFiles(stocksFilePath, transFilePath);
	}

	private void getFiles(String stocks, String transaction) throws Exception {
		Scanner input = new Scanner(new File(stocks));
		while (input.hasNextLine()) {
			companies += input.nextLine();
		}
		input = new Scanner(new File(transaction));
		while (input.hasNextLine()) {
			String next = input.nextLine();
			if (companies.contains(next)) transactions.addToFront(next);
			else {
				input.close();
				throw new Exception("Invalid Transaction Added");
			}
		}
	}
}