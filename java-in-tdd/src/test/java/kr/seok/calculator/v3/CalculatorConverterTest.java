package kr.seok.calculator.v3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
	
	private static Stream<Arguments> 우선순위_처리_방법_데이터() {
		return Stream.of(
			Arguments.of("5 + 4 * 8 / 2 - 10", "5 4 8 * 2 / 10 - +")
		);
	}
	
	@DisplayName("후위 표기법 변환 테스트")
	@MethodSource("우선순위_처리_방법_데이터")
	@ParameterizedTest(name = "{index} => 중위 표기법: {0} == 후위 표기법: {1}")
	void testCase2(String inFix, String expected) {
		CalculatorConverter calculatorConverter = new CalculatorConverter(new Calculator());
		String postFix = calculatorConverter.parseExpressionInfixToPostFix(inFix);
		assertThat(postFix).isEqualTo(expected);
	}
}