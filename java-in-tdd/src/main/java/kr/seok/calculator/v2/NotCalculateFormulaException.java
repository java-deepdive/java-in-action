package kr.seok.calculator.v2;

public class NotCalculateFormulaException extends RuntimeException {
	private static final String MESSAGE = "연산할 수 없는 식입니다. {}";

	public NotCalculateFormulaException(int express) {
		super(String.format(MESSAGE, express));
	}
}
