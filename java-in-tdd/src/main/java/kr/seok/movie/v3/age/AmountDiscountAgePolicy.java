package kr.seok.movie.v3.age;

import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Screening;

public class AmountDiscountAgePolicy extends DefaultDiscountAgePolicy {
	private final Money discountAmount;
	
	public AmountDiscountAgePolicy(Money discountAmount, DiscountAgeCondition... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}
	
	@Override
	protected Money getDiscountAmount(Screening customer) {
		return discountAmount;
	}
}
