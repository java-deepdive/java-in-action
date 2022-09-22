package kr.seok.calculator.v4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionTest {
	
	@DisplayName("중위 표기법 식을 후위 표기법으로 변환하는 테스트")
	@Test
	void testCase1() {
		Expression expression = new Expression("1 + 2");
		assertThat(expression.getValue()).isEqualTo(new String[]{"1", "2", "+"});
	}
}