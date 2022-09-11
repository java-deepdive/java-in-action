package kr.seok.calculator.v3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProxyCalculatorTest {
	
	@DisplayName("우선순위 처리 방법 테스트")
	@Test
	void testCase1() {
		ProxyCalculator proxyCalculator = new ProxyCalculator();
		String postFix = proxyCalculator.parseExpressionInfixToPostFix("1 + 2 * 3");
		System.out.println("postFix = " + postFix);
	}
}