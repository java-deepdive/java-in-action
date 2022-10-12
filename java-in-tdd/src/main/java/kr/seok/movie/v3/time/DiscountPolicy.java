package kr.seok.movie.v3.time;

import kr.seok.movie.v3.Money;
import kr.seok.movie.v3.Screening;

@FunctionalInterface
public interface DiscountPolicy {
	Money calculateDiscountAmount(Screening screening);
}
