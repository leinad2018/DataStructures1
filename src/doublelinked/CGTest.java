package doublelinked;

public class CGTest {

	public static void main(String[] args) throws Exception {
		CapitalGains gains = new CapitalGains("C:/Users/Daniel/Documents/Stocks.txt",
				"C:/Users/Daniel/Documents/Transactions.txt");
		System.out.println(gains.getCapitalGain("AAPL"));
	}
}
