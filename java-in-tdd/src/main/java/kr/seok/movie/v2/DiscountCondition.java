package kr.seok.movie.v2;

@FunctionalInterface
public interface DiscountCondition {
	boolean isSatisfiedBy(Screening screening);
}
