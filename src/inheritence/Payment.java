package inheritence;

public class Payment {
	private double payment = 0;

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
	 *            : the amount to pay
	 */
	public void setPayment(double payment) {
		this.payment = payment;
	}

	public void paymentDetails() {
		System.out.println("The payment amount is: " + payment);
	}

	public boolean equals(Object otherObject) {
		if (getClass() == otherObject.getClass() && ((Payment) otherObject).getPayment() == this.getPayment())
			return true;
		else
			return false;
	}
}
