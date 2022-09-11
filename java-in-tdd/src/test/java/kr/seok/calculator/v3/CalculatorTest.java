package kr.seok.calculator.v3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
	
	@DisplayName("기초 연산 테스트")
	@CsvSource(value = "1 + 2:3", delimiter = ':')
	@ParameterizedTest(name = "{index} => {0} {1} = {2}")
	void testCase1(String expression, double expected) {
		// given
		CalculatorInterface calculatorInterface = new Calculator();
		// when
		double calculate = calculatorInterface.calculate(expression);
		// then
		assertThat(calculate).isEqualTo(expected);
	}
	
	@DisplayName("프록시 기초 연산 테스트")
	@CsvSource(value = "1 + 2:3", delimiter = ':')
	@ParameterizedTest(name = "{index} => {0} = {1}")
	void testCase2(String expression, double expected) {
		// given
		CalculatorInterface calculatorInterface = new ProxyCalculator();
		// when
		double calculate = calculatorInterface.calculate(expression);
		// then
		assertThat(calculate).isEqualTo(expected);
	}
}