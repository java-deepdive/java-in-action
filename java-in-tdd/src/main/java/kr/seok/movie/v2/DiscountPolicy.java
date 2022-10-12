package kr.seok.movie.v2;

@FunctionalInterface
public interface DiscountPolicy {
	Money calculateDiscountAmount(Screening screening);
}
