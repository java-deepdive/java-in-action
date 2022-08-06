package kr.seok.baseball.v1.balls;

import kr.seok.baseball.v2.balls.PitchRule;
import kr.seok.baseball.v2.balls.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomsTest {
	
	@DisplayName("랜덤한 숫자를 생성할 때 제한 된 범위에서 생성되었는지 확인하는 테스트")
	@Test
	void testCase1() {
		List<Integer> rangeRandom = Randoms.createRangeRandom(PitchRule.MIN.value(), PitchRule.MAX.value());
		assertThat(rangeRandom)
			.hasSize(3)
			.hasSizeGreaterThanOrEqualTo(1)
			.hasSizeLessThanOrEqualTo(9);
	}
}