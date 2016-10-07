package doublelinked;

import java.io.File;
import java.util.Scanner;

import support.DLLNode;

public class CapitalGains {
	private DList<Stock> transactions;
	private String companies;

	public CapitalGains(String stocksFilePath, String transFilePath) throws Exception {
		transactions = new DList<Stock>();
		companies = "";
		getFiles(stocksFilePath, transFilePath);
	}

	private void getFiles(String stocks, String transaction) throws Exception {
		Scanner input = new Scanner(new File(stocks));
		while (input.hasNextLine()) {
			companies += input.nextLine();
		}
		input = new Scanner(new File(transaction));
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
		if ( !companies.contains(company)) {
			throw new Exception("Company not valid");
		}
		double cost = 0;
		DLLNode<Stock> findSale = transactions.getHeader();
		while (findSale != null) {
			System.out.println(1);
			if (findSale.getInfo().getCompany().equals(company) && findSale.getInfo().getSell()) {
				Stock sale = findSale.getInfo();
				System.out.println(2);
				cost -= sale.getValue();
				int amount = sale.getAmount();
				DLLNode<Stock> findBuy = transactions.getHeader();
				while (findBuy != findSale) {
					if (findBuy.getInfo().getCompany().equals(company)) {
						Stock buy = findBuy.getInfo();
						if (buy.getAmount() < amount) {
							cost += buy.sellStock(buy.getAmount());
							amount -= buy.getAmount();
							findBuy = findBuy.getBack();
							transactions.remove(buy);
						}
						else {
							cost += buy.sellStock(amount);
							amount = 0;
						}
					}
					findBuy = (DLLNode<Stock>)findBuy.getLink();
				}
				findSale = findSale.getBack();
				transactions.remove(sale);
			}
			findSale = (DLLNode<Stock>)findSale.getLink();
		}
		return cost;
	}
}