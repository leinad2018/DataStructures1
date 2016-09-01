package inheritence;

/**
 * A credit card payment that extends Payment
 * 
 * @author Daniel Anderson
 * 
 */
public class CreditCardPayment extends Payment {
	private String cardName = "Default";
	private String expDate = "00/00/0000";
	private String cardNum = "1234567891234567";

	/**
	 * Constructs a CreditCardPayment using the inputed amounts
	 * 
	 * @param amount
	 *            The amount of the payment
	 * @param name
	 *            The name on the Card
	 * @param date
	 *            The expiration date of the card
	 * @param num
	 *            The card number
	 */
	public CreditCardPayment(double amount, String name, String date, String num) {
		super(amount);
		cardName = name;
		expDate = date;
		cardNum = num;
	}

	/**
	 * Prints the payment details to the console
	 */
	public void paymentDetails() {
		System.out.println(cardName + "'s card. The expiration date is: "
				+ expDate + ". The card number is: " + cardNum
				+ ". The payment amount is: " + super.getPayment());
	}
}
