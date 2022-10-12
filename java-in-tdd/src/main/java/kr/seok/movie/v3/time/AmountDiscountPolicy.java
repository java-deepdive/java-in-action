package kr.seok.movie.v3.time;

import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
	private final Money discountAmount;
	
	public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}
	
	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}
}
