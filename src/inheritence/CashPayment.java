package inheritence;

/**
 * A cash payment that extends Payment
 * 
 * @author Daniel Anderson
 * 
 */
public class CashPayment extends Payment {

	/**
	 * Constructor: sets the payment to amount
	 * 
	 * @param amount
	 *            The amount of the payment
	 */
	public CashPayment(double amount) {
		super(amount);
	}

	/**
	 * Prints the payment details to the console
	 */
	public void paymentDetails() {
		System.out.println("The payment is " + super.getPayment() + " in cash");
	}
}
