package assign4;

/**
 * A class to hold information about a transaction of a stock
 * @author Daniel Anderson
 *
 */
public class Stock {
	
	private String company;
	private boolean sell;
	private int amount;
	private int costPer;

	/**
	 * Creates a new transaction using the inputed data
	 * @param data A string array of length 4 which holds the company name, if the stock is sold or bought, the amount of stock, and the cost per stock
	 */
	public Stock(String[] data){
		company = data[0];
		sell = data[1].equals("sell");
		amount = Integer.parseInt(data[2]);
		costPer = Integer.parseInt(data[3]);
	}
	
	/**
	 * Gets the amount of stock
	 * @return amount
	 */
	public int getAmount(){
		return amount;
	}
	
	/**
	 * Gets the total value of the stocks
	 * @return amount times the cost per stock
	 */
	public int getValue(){
		return amount * costPer;
	}
	
	/**
	 * Sells the inputed amount of stock
	 * @param num The amount of stock to sell
	 * @return The value of the sold stock
	 */
	public int sellStock(int num){
		if(num <= amount && !sell){
			amount -= num;
			return num * costPer;
		}else{
			return 0;
		}
	}
	
	/**
	 * If the stock is sold
	 * @return True - stock is sold<br>
	 * False - stock is bought
	 */
	public boolean isSell(){
		return sell;
	}
	
	/**
	 * Gets the name of the company that this stock is for
	 * @return company name
	 */
	public String getCompany(){
		return company;
	}
}
