package kr.seok.calculator.v4;


import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Calculator {
	
	private Calculator() {
	}
	
	public static double calculate(Expression expression) {
		Deque<Double> stack = new ConcurrentLinkedDeque<>();
		String[] tokens = expression.getValue();
		for (String operator : tokens) {
			operatorProcessing(stack, operator);
		}
		return stack.pop();
	}
	
	private static void operatorProcessing(Deque<Double> stack, String operator) {
		if (OperationProcessor.isOperator(operator)) {
			double operandLeft = stack.pop();
			double operandRight = stack.pop();
			double calculate = OperationProcessor.of(operator).calculate(operandLeft, operandRight);
			stack.push(calculate);
		} else {
			stack.push(Double.parseDouble(operator));
		}
	}
}
