package kr.seok.calculator.v4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
	
	@DisplayName("더하기 연산 테스트")
	@Test
	void testCase1() {
		double calculate = Calculator.calculate(new Expression("1 + 2"));
		assertThat(calculate).isEqualTo(3);
	}
}