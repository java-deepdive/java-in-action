package kr.seok.movie.v1;

@FunctionalInterface
public interface DiscountPolicy {
	Money calculator();
}
