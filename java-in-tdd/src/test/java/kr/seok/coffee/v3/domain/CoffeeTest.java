package kr.seok.coffee.v3.domain;

import kr.seok.coffee.v3.order.Customer;
import kr.seok.coffee.v3.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeTest {
	
	@DisplayName("커피 가격 확인 테스트")
	@Test
	void testCase1() {
		// given
		Coffee coffee = new Coffee("아메리카노", Money.wons(4500), new BenefitPolicy() {
			@Override
			public Money calculatorFee(Order coffee) {
				return Money.ZERO;
			}
		});
		// when
		Money fee = coffee.fee();
		// then
		assertThat(fee).isEqualTo(Money.wons(4500));
	}
	
	@DisplayName("커피 할인 가격 확인 테스트")
	@Test
	void testCase2() {
		// given
		Coffee coffee = new Coffee("아메리카노", Money.wons(4500), new BenefitPolicy() {
			@Override
			public Money calculatorFee(Order coffee) {
				return Money.wons(1000);
			}
		});
		// when
		Money fee = coffee.calculatorCoffeeFee(new Order(new Customer(), coffee));
		// then
		assertThat(fee).isEqualTo(Money.wons(4500));
	}
}