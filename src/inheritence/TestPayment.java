package inheritence;

public class TestPayment {

	public static void main(String[] args) {
		CashPayment cash1 = null, cash2 = new CashPayment(100);
		CreditCardPayment card1 = new CreditCardPayment(100,"bob","10/10/2010","123789039");
		cash2.paymentDetails();
		card1.paymentDetails();
		if(cash2.equals(cash1)){
			System.out.println("cash1 and cash2 are equal");
		}
		if(card1.equals(cash1)){
			System.out.println("card1 and cash1 are equal");
		}
		if(card1.equals(cash2)){
			System.out.println();
		}
	}
}
