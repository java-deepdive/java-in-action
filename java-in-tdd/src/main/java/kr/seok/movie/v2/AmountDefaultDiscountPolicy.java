package kr.seok.movie.v2;

public class AmountDefaultDiscountPolicy extends DefaultDiscountPolicy {
	private final Money discountAmount;
	
	public AmountDefaultDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
		super(conditions);
		this.discountAmount = discountAmount;
	}
	
	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}
}
