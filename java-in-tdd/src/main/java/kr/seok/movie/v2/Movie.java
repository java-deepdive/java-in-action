package kr.seok.movie.v2;


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
	
	public Money calculateMovieFee() {
		return price.minus(discountPolicy.calculator());
	}
	
	public Money getFee() {
		return price;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Movie)) return false;
		Movie movie = (Movie) o;
		return Objects.equals(title, movie.title)
			&& Objects.equals(price, movie.price);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(title, price);
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
