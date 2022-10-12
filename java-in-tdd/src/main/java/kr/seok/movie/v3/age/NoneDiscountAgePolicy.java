package kr.seok.movie.v3.age;

import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Screening;

public class NoneDiscountAgePolicy extends DefaultDiscountAgePolicy {
	
	@Override
	protected Money getDiscountAmount(Screening customer) {
		return Money.ZERO;
	}
}
