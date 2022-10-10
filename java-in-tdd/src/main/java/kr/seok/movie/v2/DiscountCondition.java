package kr.seok.movie.v2;

public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
