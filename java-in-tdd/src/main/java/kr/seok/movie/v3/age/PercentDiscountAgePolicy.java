package kr.seok.movie.v3.age;


import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Screening;

public class PercentDiscountAgePolicy extends DefaultDiscountAgePolicy {
	private final double percent;
	
	public PercentDiscountAgePolicy(double percent, DiscountAgeCondition... conditions) {
		super(conditions);
		this.percent = percent;
	}
	
	@Override
	protected Money getDiscountAmount(Screening customer) {
		return customer.getMovieFee().times(percent);
	}
}
