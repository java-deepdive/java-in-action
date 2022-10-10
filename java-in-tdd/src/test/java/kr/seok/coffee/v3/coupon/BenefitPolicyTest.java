package kr.seok.coffee.v3.coupon;

import kr.seok.coffee.v3.domain.BenefitPolicy;
import kr.seok.coffee.v3.order.NoneDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitPolicyTest {
	
	@DisplayName("할인 정책 미적용 테스트")
	@Test
	void testCase1() {
		// given
		BenefitPolicy benefitPolicy = new NoneDiscountPolicy();
	}
}