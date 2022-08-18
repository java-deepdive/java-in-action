package kr.seok.calculator.v1;


import kr.seok.calculator.v1.exception.CalculatorException;

import java.util.Objects;

public class Number {
	
	private final int value;
	
	protected Number(int value) {
		this.value = value;
	}
	
	public static Number of(String number) {
		if (Validator.isNotNumericOrIsNegativeNumber(number)) {
			throw new CalculatorException("계산할 수 없는 문자 입니다.");
		}
		return new Number(Integer.parseInt(number));
	}
	
	public static Number of(int number) {
		return new Number(number);
	}
	public int getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Number)) return false;
		final Number number1 = (Number) o;
		return getValue() == number1.getValue();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getValue());
	}
}
