package kr.seok.movie.v3.time;

import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
	private final double percent;
	
	public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
		super(conditions);
		this.percent = percent;
	}
	
	@Override
	protected Money getDiscountAmount(Screening screening) {
		return screening.getMovieFee().times(percent);
	}
}
