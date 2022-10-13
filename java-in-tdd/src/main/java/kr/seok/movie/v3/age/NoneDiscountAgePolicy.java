package kr.seok.movie.v3.age;

import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Reservation;

public class NoneDiscountAgePolicy implements DiscountAgePolicy {
	
	@Override
	public Money calculateDiscountAmount(Reservation customer) {
		return Money.ZERO;
	}
}
