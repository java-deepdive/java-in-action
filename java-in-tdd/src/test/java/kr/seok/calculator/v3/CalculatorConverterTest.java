package kr.seok.calculator.v3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorConverterTest {
	
	@DisplayName("우선순위 처리 방법 테스트")
	@Test
	void testCase1() {
		CalculatorConverter calculatorConverter = new CalculatorConverter(new Calculator());
		String postFix = calculatorConverter.parseExpressionInfixToPostFix("1 + 2 * 3");
		System.out.println("postFix = " + postFix);
	}
}