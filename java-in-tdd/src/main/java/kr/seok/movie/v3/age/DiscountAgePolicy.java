package kr.seok.movie.v3.age;

import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Reservation;

@FunctionalInterface
public interface DiscountAgePolicy {
	Money calculateDiscountAmount(Reservation customer);
}
