package kr.seok.movie.v2;

public interface DiscountPolicy {
	Money calculateDiscountAmount(Screening screening);
}
