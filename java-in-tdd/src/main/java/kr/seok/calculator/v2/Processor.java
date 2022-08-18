package kr.seok.calculator.v2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public enum Processor {
	PLUS("+", Double::sum),
	SUBTRACT("-", (left, right) -> (left - right)),
	MULTIPLY("*", (left, right) -> (left * right)),
	DIVIDE("/", (left, right) -> {
		double result = left / right;
		if (Double.isInfinite(result)) {
			throw new ArithmeticException("0으로는 나눌 수 없습니다.");
		}
		return result;
	});

	private static final String OPERATOR_VALUE = "^[+\\-*/]$";
	private final String operator;
	private final BiFunction<Double, Double, Double> expression;

	Processor(String operator, BinaryOperator<Double> expression) {
		this.operator = operator;
		this.expression = expression;
	}

	public static Processor of(String operator) {
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
	
	public double calculate(Operand left, Operand right) {
		return expression.apply(left.value(), right.value());
	}
	
	private static boolean isMatchesOperator(String operator, Processor op) {
		return op.operator.equals(operator);
	}
}