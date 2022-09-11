package kr.seok.calculator.v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ExpressionTest {
	
	@DisplayName("식 검증 테스트")
	@Test
	void testCase1() {
		// given
		Expression expression = new Expression("1 + 2");
		// when
		// then
		assertAll(
			() -> assertThat(expression.operator()).isEqualTo(new Operator("+"))
			, () -> assertThat(expression.operand()).isEqualTo(new Operand(1))
			, () -> assertThat(expression.operand()).isEqualTo(new Operand(2))
		);
	}
}