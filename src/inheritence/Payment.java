package inheritence;

/**
 * A Payment
 * 
 * @author Daniel Anderson
 * 
 */
public class Payment {
	private double payment = 0;

	/**
	 * Constructs a payment using the inputted amount
	 * 
	 * @param amount
	 *            The amount of the payment
	 */
	public Payment(double amount) {
		payment = amount;
	}

	/**
	 * Gets the amount of the payment
	 * 
	 * @return amount
	 */
	public double getPayment() {
		return payment;
	}

	/**
	 * Sets the amount of the payment
	 * 
	 * @param payment
	 *            The amount to pay
	 */
	public void setPayment(double payment) {
		this.payment = payment;
	}

	/**
	 * Prints the amount of the payment to the console
	 */
	public void paymentDetails() {
		System.out.println("The payment amount is: " + payment);
	}

	/**
	 * Checks if the other payment is of the same type and amount of this object
	 * 
	 * @param otherObject
	 *            The object to compare
	 */
	public boolean equals(Object otherObject) {
		if(otherObject == null){
			return false;
		}
		if (getClass() == otherObject.getClass()
				&& ((Payment) otherObject).getPayment() == this.getPayment())
			return true;
		else
			return false;
	}
}
