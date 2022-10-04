package kr.seok.coffee.v3;

import kr.seok.coffee.v3.money.Money;
import kr.seok.coffee.v3.order.NoneDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeTest {
	
	@DisplayName("커피 가격 쿠폰 미적용 금액 테스트")
	@Test
	void testCase1() {
		// given
		Coffee coffee = new Coffee("아메리카노", Money.wons(15000), new NoneDiscountPolicy());
		// when
		Money fee = coffee.fee();
		// then
		assertThat(fee).isEqualTo(Money.wons(15000));
	}
}