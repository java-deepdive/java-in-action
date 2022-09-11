package kr.seok.calculator.v3;


import java.util.Stack;

public class ProxyCalculator implements CalculatorInterface {
	
	private Calculator calculator;
	
	@Override
	public double calculate(String expression) {
		if (calculator == null) {
			this.calculator = new Calculator();
		}
		String postFix = parseExpressionInfixToPostFix(expression);
		return calculator.calculate(postFix);
	}
	
	protected String parseExpressionInfixToPostFix(String expression) {
		StringBuilder stringBuilder = new StringBuilder();
		Stack<String> stack = new Stack<>();
		String[] expSplit = expression.split(" ");
		for (String s : expSplit) {
			if (OperationProcessor.isOperator(s)) {
				if (!stack.isEmpty()) {
					if (OperationProcessor.compareTo(stack.peek(), s)) {
						stringBuilder.append(stack.pop());
						stringBuilder.append(" ");
					}
				}
				stack.push(s);
			} else {
				stringBuilder.append(s);
				stringBuilder.append(" ");
			}
		}
		while (!stack.isEmpty()) {
			stringBuilder.append(stack.pop());
			stringBuilder.append(" ");
		}
		
		return stringBuilder.toString().trim();
	}
}
