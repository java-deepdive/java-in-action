package kr.seok.movie.v2;

public class PercentDefaultDiscountPolicy extends DefaultDiscountPolicy {
	private final double percent;
	
	public PercentDefaultDiscountPolicy(double percent, DiscountCondition... conditions) {
		super(conditions);
		this.percent = percent;
	}
	
	@Override
	protected Money getDiscountAmount(Screening screening) {
		return screening.getMovieFee().times(percent);
	}
}
