package kr.seok.chapter11.biling.step05;

import kr.seok.chapter10.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RatePolicyTest {
	
	@DisplayName("할인 적용 테스트")
	@Test
	void testCase1() {
		// given
		RatePolicy ratePolicy =
			new RateDiscountablePolicy(
				Money.wons(1000),
				new RegularPolicy(
					Money.wons(1000),
					Duration.ofSeconds(10))
			);
		// when
		Money fee = ratePolicy.calculateFee(new Phone(ratePolicy));
		// then
		assertThat(fee).isEqualTo(Money.wons(9000));
	}
}