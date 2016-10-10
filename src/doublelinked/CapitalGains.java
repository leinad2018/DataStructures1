package doublelinked;

import java.io.File;
import java.util.Scanner;

import support.DLLNode;

public class CapitalGains {
	private DList<Stock> transactions;
	private String companies;
	private String stocksFilePath,transFilePath;

	public CapitalGains(String stocksFilePath, String transFilePath) throws Exception {
		this.stocksFilePath = stocksFilePath;
		this.transFilePath = transFilePath;
	}

	private void getFiles() throws Exception {
		transactions = new DList<Stock>();
		companies = "";
		Scanner input = new Scanner(new File(stocksFilePath));
		while (input.hasNextLine()) {
			companies += input.nextLine();
		}
		input = new Scanner(new File(transFilePath));
		while (input.hasNextLine()) {
			String[] next = input.nextLine().split(";");
			next[3] = next[3].substring(1);
			if (companies.contains(next[0])) {
				Stock x = new Stock(next);
				transactions.addToFront(x);
			}
			else {
				input.close();
				throw new Exception("Invalid Transaction Added");
			}
		}
	}

	public double getCapitalGain(String company) throws Exception {
		getFiles();
		if ( !companies.contains(company)) {
			throw new Exception("Company not valid");
		}
		DList<Stock> toCalc = new DList<Stock>();
		DLLNode<Stock> getStock = transactions.getHeader();
		while (getStock != null) {
			Stock stock = getStock.getInfo();
			if(stock.getCompany().equals(company)){
				
			}
		}
		return cost;
	}
}