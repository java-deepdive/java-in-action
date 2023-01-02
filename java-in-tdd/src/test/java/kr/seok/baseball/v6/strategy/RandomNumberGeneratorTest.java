package kr.seok.baseball.v6.strategy;

import kr.seok.baseball.v6.numbers.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RandomNumberGeneratorTest {
	
	@DisplayName("랜덤 숫자 생성 테스트")
	@Test
	void testCase1() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		Balls hits = randomNumberGenerator.hits(3);
		assertAll("balls"
				, () -> assertThat(hits).isNotNull()
				, () -> assertThat(hits.size()).isEqualTo(3)
		);
	}
}