package kr.seok.coffee.v3.coupon;

import kr.seok.coffee.v3.money.Money;
import kr.seok.coffee.v3.order.Order;

public abstract class DiscountPolicy implements BenefitPolicy {
	
	private final BenefitPolicy benefitPolicy;
	
	DiscountPolicy(BenefitPolicy benefitPolicy) {
		this.benefitPolicy = benefitPolicy;
	}
	
	@Override
	public Money calculatorFee(Order coffee) {
		Money orderSpecification = benefitPolicy.calculatorFee(coffee);
		return applyDiscount(orderSpecification);
	}
	
	protected abstract Money applyDiscount(Money orderSpecification);
}
