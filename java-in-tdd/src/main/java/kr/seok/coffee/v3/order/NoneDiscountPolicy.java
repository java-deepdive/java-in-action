package kr.seok.coffee.v3.order;

import kr.seok.coffee.v3.coupon.BenefitPolicy;
import kr.seok.coffee.v3.money.Money;

public class NoneDiscountPolicy implements BenefitPolicy {
	@Override
	public Money calculatorFee(Order coffee) {
		return Money.ZERO;
	}
}
