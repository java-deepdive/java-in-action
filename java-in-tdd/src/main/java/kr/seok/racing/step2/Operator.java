package kr.seok.racing.step2;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import static kr.seok.racing.step2.Constants.ILLEGAL_ARGUMENT_EXCEPTION_SUPPLIER;
import static kr.seok.racing.step2.Validator.isDivideByZero;

/**
 * 상태와 행위를 한 곳에서 관리하기 위한 enum 활용
 */
public enum Operator {
	
	PLUS("+", Integer::sum), // 람다 -> 메서드 레퍼런스로 변경 가능
	SUBTRACT("-", (a, b) -> (a - b)),
	MULTIPLY("*", (a, b) -> (a * b)),
	DIVIDE("/", (a, b) -> {
		isDivideByZero(a);
		return (a / b);
	});
	
	private final String operator;
	private final BinaryOperator<Integer> formula;
	
	Operator(String operator, BinaryOperator<Integer> formula) {
		this.operator = operator;
		this.formula = formula;
	}
	
	// 넘어온 문자가 사칙 연산에 존재하는 경우 해당 연산자를 반환
	public static Operator of(String operation) {
		return Arrays.stream(Operator.values())
			.filter(o -> isEquals(operation, o))
			.findAny()
			.orElseThrow(ILLEGAL_ARGUMENT_EXCEPTION_SUPPLIER);
	}
	
	// 사칙연산에 대한 리스트를 반환할 필요없이 유효성 검사 코드를 여기서 관리
	public static boolean isOperation(String operation) {
		return Arrays.stream(Operator.values())
			.anyMatch(o -> isEquals(operation, o));
	}
	
	private static boolean isEquals(String operation, Operator o) {
		return o.of().equals(operation);
	}
	
	public Integer calculate(Integer a, Integer b) {
		return formula.apply(a, b);
	}
	
	private String of() {
		return operator;
	}
	
}
