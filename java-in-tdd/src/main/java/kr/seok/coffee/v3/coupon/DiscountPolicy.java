package kr.seok.coffee.v3.coupon;

import kr.seok.coffee.v3.Coffee;
import kr.seok.coffee.v3.money.Money;

public abstract class DiscountPolicy implements BenefitPolicy {
	
	private final BenefitPolicy benefitPolicy;
	
	DiscountPolicy(BenefitPolicy benefitPolicy) {
		this.benefitPolicy = benefitPolicy;
	}
	
	@Override
	public Money apply(Coffee coffee) {
		Money orderSpecification = benefitPolicy.apply(coffee);
		return applyDiscount(orderSpecification);
	}
	
	protected abstract Money applyDiscount(Money orderSpecification);
}
