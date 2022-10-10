package kr.seok.coffee.v3.order;

import kr.seok.coffee.v3.domain.BenefitPolicy;
import kr.seok.coffee.v3.domain.Coffee;
import kr.seok.coffee.v3.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {
	
	@DisplayName("주문 생성 테스트")
	@Test
	void testCase1() {
		Coffee coffee = new Coffee("아메리카노", Money.wons(4500), new BenefitPolicy() {
			@Override
			public Money calculatorFee(Order coffee) {
				return Money.ZERO;
			}
		});
		Order order = new Order(new Customer(), coffee);
		Money calculator = order.takeOut();
		
		assertThat(calculator).isEqualTo(Money.wons(4500));
	}
}