package doublelinked;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CapitalGains {
	private DList companies;
	
	public CapitalGains(String stocksFilePath, String transFilePath) throws FileNotFoundException{
		getFiles(stocksFilePath, transFilePath);
	}
	
	private void getFiles(String stocks, String transactions) throws FileNotFoundException{
		Scanner stocksIn = new Scanner(new File(stocks));
		
	}
}
