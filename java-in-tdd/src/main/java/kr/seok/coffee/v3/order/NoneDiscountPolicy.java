package kr.seok.coffee.v3.order;

import kr.seok.coffee.v3.domain.BenefitPolicy;
import kr.seok.coffee.v3.domain.Money;

public class NoneDiscountPolicy implements BenefitPolicy {
	@Override
	public Money calculatorFee(Order coffee) {
		return Money.ZERO;
	}
}
