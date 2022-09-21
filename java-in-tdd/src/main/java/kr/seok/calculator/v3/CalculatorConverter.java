package kr.seok.calculator.v3;


import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public final class CalculatorConverter extends CalculatorDecorator {
	
	private Calculator calculator;
	
	public CalculatorConverter(CalculatorInterface calculator) {
		super(calculator);
	}
	
	public double calculate(String expression) {
		if (calculator == null) {
			this.calculator = new Calculator();
		}
		String postFix = parseExpressionInfixToPostFix(expression);
		return calculator.calculate(postFix);
	}
	
	String parseExpressionInfixToPostFix(String expression) {
		StringBuilder stringBuilder = new StringBuilder();
		Deque<String> stack = new ConcurrentLinkedDeque<>();
		String[] expSplit = expression.split(" ");
		for (String s : expSplit) {
			makePostfixExpression(stringBuilder, stack, s);
		}
		while (!stack.isEmpty()) {
			stringBuilder.append(stack.pop());
			stringBuilder.append(" ");
		}
		return stringBuilder.toString().trim();
	}
	
	private void makePostfixExpression(StringBuilder stringBuilder, Deque<String> stack, String s) {
		if (OperationProcessor.isOperator(s)) {
			if (!stack.isEmpty() && OperationProcessor.compareTo(stack.peek(), s)) {
				stringBuilder.append(stack.pop());
				stringBuilder.append(" ");
			}
			stack.push(s);
		} else {
			stringBuilder.append(s);
			stringBuilder.append(" ");
		}
	}
}
