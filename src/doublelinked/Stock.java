package doublelinked;

public class Stock {
	private String company;
	private boolean sell;
	private int amount;
	private int costPer;

	public Stock(String[] data){
		company = data[0];
		sell = data[1].equals("sell");
		amount = Integer.parseInt(data[2]);
		costPer = Integer.parseInt(data[3]);
	}
	
	public int getAmount(){
		return amount;
	}
	
	public double getValue(){
		return amount * costPer;
	}
	
	public double sellStock(int num){
		if(num <= amount && !sell){
			return num * costPer;
		}else{
			return 0;
		}
	}
	
	public boolean isSell(){
		return sell;
	}
	
	public String getCompany(){
		return company;
	}
}
