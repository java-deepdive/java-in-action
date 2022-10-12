package kr.seok.movie.v3;


import kr.seok.movie.v3.time.DiscountPolicy;

import java.util.Objects;

public class Movie {
	private final String title;
	private final Money price;
	private final DiscountPolicy discountPolicy;
	
	public Movie(String title, Money price, DiscountPolicy discountPolicy) {
		this.title = title;
		this.price = price;
		this.discountPolicy = discountPolicy;
	}
	
	public Money calculateMovieFee(Screening screening) {
		return price.minus(discountPolicy.calculateDiscountAmount(screening));
	}
	
	public Money getFee() {
		return price;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Movie)) return false;
		Movie movie = (Movie) o;
		return Objects.equals(title, movie.title);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(title);
	}
	
	@Override
	public String toString() {
		return "Movie{" +
			"title='" + title + '\'' +
			", price=" + price +
			", discountPolicy=" + discountPolicy +
			'}';
	}
}
