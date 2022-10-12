package kr.seok.movie.v3.time;

import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
	
	@Override
	public Money calculateDiscountAmount(Screening screening) {
		return Money.ZERO;
	}
}
