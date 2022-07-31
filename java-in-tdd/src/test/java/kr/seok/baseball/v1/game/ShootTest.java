package kr.seok.baseball.v1.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShootTest {
	
	@DisplayName("랜덤 사용방법 테스트")
	@Test
	void testCase1() {
		Shoot shoot = new Shoot();
		int run = shoot.run();
		assertThat(run).isLessThan(10);
	}
}