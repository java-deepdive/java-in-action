package kr.seok.movie.v3.time;

import kr.seok.movie.v3.Screening;

@FunctionalInterface
public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
