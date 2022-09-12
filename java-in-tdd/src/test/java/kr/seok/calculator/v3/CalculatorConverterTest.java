package kr.seok.calculator.v3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorConverterTest {
	
	@DisplayName("우선순위 처리 방법 테스트")
	@CsvSource(value = "1 + 2 * 3:1 2 3 * +", delimiter = ':')
	@ParameterizedTest(name = "{index} => 중위 표기법: {0} == 후위 표기법: {1}")
	void testCase1(String actual, String expected) {
		CalculatorConverter calculatorConverter = new CalculatorConverter(new Calculator());
		String postFix = calculatorConverter.parseExpressionInfixToPostFix(actual);
		assertThat(postFix).isEqualTo(expected);
	}
}