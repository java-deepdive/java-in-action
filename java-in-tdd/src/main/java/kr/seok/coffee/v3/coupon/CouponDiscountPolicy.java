package kr.seok.coffee.v3.coupon;

import kr.seok.coffee.v3.domain.BenefitPolicy;
import kr.seok.coffee.v3.domain.Money;

public class CouponDiscountPolicy extends DefaultDiscountPolicy {
	
	private final Money discountAmt;
	
	public CouponDiscountPolicy(Money discountAmt, BenefitPolicy next) {
		super(next);
		this.discountAmt = discountAmt;
	}
	
	@Override
	protected Money applyDiscount(Money fee) {
		return fee.minus(discountAmt);
	}
}
