package kr.seok.calculator.v3;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public enum OperationProcessor {
	PLUS("+", 0, Double::sum),
	SUBTRACT("-", 0, (left, right) -> (left - right)),
	MULTIPLY("*", 1, (left, right) -> (left * right)),
	DIVIDE("/", 1, (left, right) -> {
		double result = left / right;
		if (Double.isInfinite(result)) {
			throw new ArithmeticException("0으로는 나눌 수 없습니다.");
		}
		return result;
	});
	
	private static final String OPERATOR_VALUE = "^[+\\-*/]$";
	private final String operator;
	private final int priority;
	private final BiFunction<Double, Double, Double> expression;
	
	OperationProcessor(String operator, int priority, BinaryOperator<Double> expression) {
		this.operator = operator;
		this.priority = priority;
		this.expression = expression;
	}
	
	public static OperationProcessor of(String operator) {
		return Arrays.stream(values())
			.filter(op -> isMatchesOperator(operator, op))
			.findFirst()
			.orElseThrow(() -> new NotSupportedOperationException(operator));
	}
	
	public static boolean isOperator(String userInput) {
		return Optional.ofNullable(userInput)
			.filter(s -> s.matches(OPERATOR_VALUE))
			.isPresent();
	}
	
	public static boolean compareTo(String peek, String s) {
		return OperationProcessor.of(peek).priority >= OperationProcessor.of(s).priority;
	}
	
	public double calculate(double left, double right) {
		return expression.apply(left, right);
	}
	
	private static boolean isMatchesOperator(String operator, OperationProcessor op) {
		return op.operator.equals(operator);
	}
}