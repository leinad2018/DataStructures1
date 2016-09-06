package inheritence;

public class TestPayment {

	public static void main(String[] args) {
		CashPayment cash1 = new CashPayment(-100), cash2 = new CashPayment(100);
		CreditCardPayment card1 = new CreditCardPayment(100.50,"bob","10/10/2010","123789039")
				,card2 = new CreditCardPayment(100.50, "steve", "09/23/1238", "848493");
		cash1.paymentDetails();
		cash2.paymentDetails();
		System.out.println();
		card1.paymentDetails();
		card2.paymentDetails();
		System.out.println();
		if(cash2.equals(cash1)){
			System.out.println("cash1 and cash2 are equal");
		}
		if(card1.equals(cash1)){
			System.out.println("card1 and cash1 are equal");
		}
		if(card1.equals(card2)){
			System.out.println("card1 and card2 are equal");
		}
	}
}
