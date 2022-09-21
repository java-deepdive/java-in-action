package kr.seok.calculator.v5;

import kr.seok.calculator.v3.NotSupportedOperationException;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.toMap;

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
	
	private final String operator;
	private final int priority;
	private final BinaryOperator<Double> expression;
	
	private static final Map<String, OperationProcessor> OPERATOR_MAP =
		Arrays.stream(OperationProcessor.values())
			.collect(toMap(OperationProcessor::getOperator, operation -> operation));
	
	OperationProcessor(String operator, int priority, BinaryOperator<Double> expression) {
		this.operator = operator;
		this.priority = priority;
		this.expression = expression;
	}
	
	public static OperationProcessor of(String operator) {
		return Optional.ofNullable(OPERATOR_MAP.get(operator))
			.orElseThrow(() -> new NotSupportedOperationException(operator));
	}
	
	public static boolean isOperator(String userInput) {
		return OPERATOR_MAP.containsKey(userInput);
	}
	
	public static boolean compareTo(String peek, String s) {
		return OperationProcessor.of(peek).priority >= OperationProcessor.of(s).priority;
	}
	
	public double calculate(double left, double right) {
		return expression.apply(left, right);
	}
	
	private String getOperator() {
		return operator;
	}
}