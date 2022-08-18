package kr.seok.calculator.v2;

public class NotSupportedOperationException extends RuntimeException {
	private static final String MESSAGE = "지원하지 않는 연산입니다. {}";

	public NotSupportedOperationException(String express) {
		super(String.format(MESSAGE, express));
	}
}
