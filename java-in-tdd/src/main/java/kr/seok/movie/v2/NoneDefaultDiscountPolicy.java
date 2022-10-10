package kr.seok.movie.v2;

public class NoneDefaultDiscountPolicy implements DiscountPolicy {
	
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return Money.ZERO;
	}
}
