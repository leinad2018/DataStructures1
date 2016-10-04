package ch03.stacks;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class LispEvaluator {
	private LinkedStack<String> numbers;
	private LinkedStack<Character> operators;

	/**
	 * Makes a new LispEvaluator class
	 */
	public LispEvaluator() {
		numbers = new LinkedStack<String>();
		operators = new LinkedStack<Character>();
	}

	/**
	 * Evaluates a valid Lisp expression<br>
	 * Preconditions: equation is a valid expression<br>
	 * Postconditions: returns the result of the evaluation
	 * 
	 * @param equation
	 *            The expression to evaluate
	 * @return The value of the equation
	 * @throws InvalidParameterException
	 */
	public double evaluate(String equation) throws InvalidParameterException {
		String toSplit;
		toSplit = addSpace(equation);
		String buffer = "";
		String operations = "+-*/";

		String[] storage = toSplit.split(" ");
		for (String x : storage) {
			if (x.length() > 0) {
				if (x.length() > 1) {
					numbers.push(x);

				} else if (operations.contains(x)) {
					operators.push(x.charAt(0));

				} else if (x.equals(")")) {
					ArrayList<String> toEv = new ArrayList<String>();

					while (!(numbers.top().equals("("))) {
						toEv.add(numbers.top());
						numbers.pop();
					}
					numbers.pop();

					char op = operators.top();
					operators.pop();
					numbers.push(doesMath(op, toEv));
				} else {
					numbers.push(x);
				}
			}
		}
		double result = Double.parseDouble(numbers.top());
		numbers.pop();
		return result;
	}

	// Adds spaces to parenthesis so that the algorithm will work
	private String addSpace(String equation) {
		String toReturn = equation.replaceAll("\\(", "( ");
		toReturn = toReturn.replaceAll("\\)", " )");
		return toReturn;
	}

	// Does all of the math for the evaluate method
	private String doesMath(char operation, ArrayList<String> numbers)
			throws IllegalArgumentException {
		double toReturn = 0;
		switch (operation) {
		case '+':
			if (numbers.size() == 0) {
				return "0";
			}
			for (int i = 0; i < numbers.size(); i++) {
				toReturn += Double.parseDouble(numbers.get(i));
			}
			break;
		case '-':
			if (numbers.size() == 0) {
				throw new IllegalArgumentException(
						"Subtraction needs at least 1 operand");
			}
			if (numbers.size() == 1) {
				toReturn = -Double.parseDouble(numbers.get(0));
				break;
			}
			toReturn = Double.parseDouble(numbers.get(numbers.size() - 1));
			for (int i = numbers.size() - 2; i >= 0; i--) {
				toReturn -= Double.parseDouble(numbers.get(i));
			}
			break;
		case '/':
			toReturn = 1;
			if (numbers.size() == 0) {
				throw new IllegalArgumentException(
						"Division needs at least 1 operand");
			}
			if (numbers.size() == 1) {
				double temp = Double.parseDouble(numbers.get(0));
				if (temp == 0) {
					throw new RuntimeException("Divide by Zero");
				}
				return "" + 1 / temp;
			}
			toReturn = Double.parseDouble(numbers.get(numbers.size() - 1));
			for (int i = numbers.size() - 2; i >= 0; i--) {
				if (Double.parseDouble(numbers.get(i)) == 0) {
					throw new RuntimeException("Divide by Zero");
				}
				toReturn /= Double.parseDouble(numbers.get(i));
			}
			break;
		case '*':
			toReturn = 1;
			for (int i = 0; i < numbers.size(); i++) {
				toReturn *= Double.parseDouble(numbers.get(i));
			}
			break;
		}

		return toReturn + "";
	}
}
