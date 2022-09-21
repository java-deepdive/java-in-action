package kr.seok.calculator.v4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {
	
	@Test
	void testCase1() {
		Expression expression = new Expression("1 + 2");
		assertThat(expression.getValue()).isEqualTo(new String[]{"1 2 +"});
	}
}