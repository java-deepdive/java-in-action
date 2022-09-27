package kr.seok.coffee.v3.coupon;

import kr.seok.coffee.v3.Coffee;
import kr.seok.coffee.v3.money.Money;

public class NoneBenefitPolicy implements BenefitPolicy {
	public NoneBenefitPolicy(Money amount) {
	}
	
	@Override
	public Money apply(Coffee coffee) {
		return null;
	}
}
