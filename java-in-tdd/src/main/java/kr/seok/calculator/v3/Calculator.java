package kr.seok.calculator.v3;

import java.util.Stack;

/**
 * 후위 표기법으로 정의된 수식을 계산하는 클래스
 */
public class Calculator implements CalculatorInterface {
	
	public double calculate(String expression) {
		String[] tokens = expression.split(" ");
		Stack<Double> stack = new Stack<>();
		for (String token : tokens) {
			if (OperationProcessor.isOperator(token)) {
				double b = stack.pop();
				double a = stack.pop();
				double calculate = OperationProcessor.of(token).calculate(a, b);
				stack.push(calculate);
			} else {
				stack.push(Double.parseDouble(token));
			}
		}
		return stack.peek();
	}
}
