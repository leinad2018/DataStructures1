package ch03.stacks;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.omg.CORBA.DynAnyPackage.InvalidValue;

public class LispEvaluator {
	private LinkedStack<String> numbers;
	private LinkedStack<Character> operators;
	
	public LispEvaluator(){
		numbers = new LinkedStack<String>();
		operators = new LinkedStack<Character>();
	}
	
	public double evaluate(String equation) throws InvalidParameterException{
		String stuff;
		stuff = addSpace(equation);
		String buffer = "";
		String operations = "+-*/";
		
		for(int i = 0; i < stuff.length(); i++){
			char temp = stuff.charAt(i);
			
			if(temp == ' '){
				numbers.push(buffer);
				buffer = "";
			}
			
			if(temp == ')'){
				ArrayList<String> toEv = new ArrayList<String>();
				
				while(numbers.top() != "("){
					toEv.add(numbers.top());
					numbers.pop();
				}
				numbers.pop();
				
				char op = operators.top();
				operators.pop();
				numbers.push(doesMath(op, toEv));
				
			}else if(operations.contains(temp + "")){
				operators.push(temp);
				
			}else {
				buffer += temp;
				
			}
		}
		return 0;
	}
	
	private String addSpace(String equation){
		String toReturn = equation.replaceAll("\\(", "( ");
		toReturn = toReturn.replaceAll("\\)", " )");
		return toReturn;
	}
	
	private String doesMath(char operation, ArrayList<String> numbers)throws IllegalArgumentException{
		double toReturn = 0;
		switch(operation){
		case '+':
			if(numbers.size() == 0){
				return "0";
			}
			for(int i = 0; i < numbers.size(); i++){
				toReturn += Double.parseDouble(numbers.get(i));
			}
			return toReturn + "";
		case '-':
			if(numbers.size() == 0){
				throw new IllegalArgumentException("Subtraction needs at least 1 operand");
			}
		}
		
		return null;
	}
}
