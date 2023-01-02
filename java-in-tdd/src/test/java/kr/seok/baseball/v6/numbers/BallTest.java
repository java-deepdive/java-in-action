package kr.seok.baseball.v6.numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BallTest {
	
	@Test
	void testCase1() {
		Ball ball = new Ball(3);
		assertThat(ball).isEqualTo(new Ball(3));
	}
}