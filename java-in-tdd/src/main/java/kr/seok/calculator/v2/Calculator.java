package kr.seok.calculator.v2;

public final class Calculator {
	private static final int ZERO_SIZE = 0;
	
	private Calculator() {
	}
	
	public static double calculate(Expression expression) {
		Operand result = expression.operand();
		while (expression.size() > ZERO_SIZE) {
			Operator operator = expression.operator();
			Operand operand = expression.operand();
			result = new Operand(operator.calculate(result, operand));
		}
		return result.value();
	}
}
