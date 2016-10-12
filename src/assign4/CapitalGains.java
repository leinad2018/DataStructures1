package assign4;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.Scanner;

import support.DLLNode;

/**
 * A Class to calculate capital gains for stocks
 * @author Daniel Anderson
 *
 */
public class CapitalGains {
	private DList<Stock> transactions;
	private String stocksFilePath, transFilePath;

	/**
	 * Constructs a CapitalGains object
	 * @param stocksFilePath The file path of the Stocks file
	 * @param transFilePath The file path of the Transactions file
	 */
	public CapitalGains(String stocksFilePath, String transFilePath){
		this.stocksFilePath = stocksFilePath;
		this.transFilePath = transFilePath;
	}

	/**
	 * Gets the transactions for the inputed company
	 * @param company The company for which transactions should be found
	 * @throws InvalidParameterException If company is not listed in the stocks file
	 */
	private void getFiles(String company) throws InvalidParameterException{
		transactions = new DList<Stock>();
		Scanner input;
		try {
			input = new Scanner(new File(stocksFilePath));
		} catch (FileNotFoundException e) {
			System.out.println("File read failed: Files not found");
			return;
		}
		String comp = null;

		while (input.hasNextLine()) {
			String test = input.nextLine();
			test = test.substring(0, test.indexOf(';'));
			if (test.equals(company)) {
				comp = test;
			}
		}

		if (comp == null) {
			throw new InvalidParameterException("Invalid Company");
		}

		try {
			input = new Scanner(new File(transFilePath));
			System.out.println("Files read successfully");
		} catch (FileNotFoundException e) {
			System.out.println("File read failed: Files not found");
			return;
		}
		while (input.hasNextLine()) {
			String[] next = input.nextLine().split(";");
			if (!next[0].equals(company)) {
				continue;
			}
			next[3] = next[3].substring(1);
			Stock x = new Stock(next);
			transactions.addToLast(x);
		}
	}

	/**
	 * Gets the total capital gain for a certain stock
	 * @param company Which company capital gain should be calculated for
	 * @return The capital gain of the company
	 * @throws InvalidParameterException If company is not listed in the stocks file 
	 * @throws FileNotFoundException If the files cannot be found at the file path
	 * @throws InvalidSale If the amount sold of a stock is larger than the amount purchased at any time
	 */
	public int getCapitalGain(String company) throws InvalidParameterException,FileNotFoundException,InvalidSale{
		getFiles(company);
		int cost = 0;

		DList<Stock> toCalc = new DList<Stock>();
		DLLNode<Stock> getStock = transactions.getHeader();
		while (getStock != null) {
			Stock stock = getStock.getInfo();
			if (stock.isSell()) {
				int amount = stock.getAmount();
				cost += stock.getValue();
				DLLNode<Stock> getBuy = transactions.getHeader();
				while(getBuy != getStock && amount > 0){
					Stock buy = getBuy.getInfo();
					if(amount > buy.getAmount()){
						amount -= buy.getAmount();
						cost -= buy.sellStock(buy.getAmount());
					}else{
						cost -= buy.sellStock(amount);
						amount -= amount;
					}
					
					getBuy = (DLLNode<Stock>) getBuy.getLink();
				}
				if(amount > 0){
					throw new InvalidSale("Sales exceed amount purchased");
				}
			}
			
			getStock = (DLLNode<Stock>) getStock.getLink();
		}
		return cost;
	}
}