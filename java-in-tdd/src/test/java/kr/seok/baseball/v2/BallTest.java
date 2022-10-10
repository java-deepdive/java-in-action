package kr.seok.baseball.v2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
	
	@Test
	void testCase1() {
		Ball ball = new Ball(1);
		assertThat(ball).isEqualTo(new Ball(1));
	}
}