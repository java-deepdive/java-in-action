package kr.seok.calculator.v2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

public enum OperationProcessor {
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
	private final DoubleBinaryOperator expression;
	
	OperationProcessor(String operator, DoubleBinaryOperator expression) {
		this.operator = operator;
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
	
	public double calculate(Operand left, Operand right) {
		return expression.applyAsDouble(left.value(), right.value());
	}
	
	private static boolean isMatchesOperator(String operator, OperationProcessor op) {
		return op.operator.equals(operator);
	}
}