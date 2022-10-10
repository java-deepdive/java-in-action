package kr.seok.coffee.v3.coupon;

import kr.seok.coffee.v3.domain.BenefitPolicy;
import kr.seok.coffee.v3.domain.Money;
import kr.seok.coffee.v3.order.Order;

public abstract class DefaultDiscountPolicy implements BenefitPolicy {
	
	private final BenefitPolicy benefitPolicy;
	
	DefaultDiscountPolicy(BenefitPolicy benefitPolicy) {
		this.benefitPolicy = benefitPolicy;
	}
	
	@Override
	public Money calculatorFee(Order coffee) {
		Money orderSpecification = benefitPolicy.calculatorFee(coffee);
		return applyDiscount(orderSpecification);
	}
	
	protected abstract Money applyDiscount(Money orderSpecification);
}
