package kr.seok.movie.v3;


import kr.seok.movie.v3.age.DiscountAgePolicy;

public class Reservation {
	private final Customer customer;
	private final Screening screening;
	private final Money fee;
	private final int audienceCount;
	private final DiscountAgePolicy discountAgePolicy;
	
	public Reservation(Customer customer, Screening screening, Money money, int audienceCount, DiscountAgePolicy discountAgePolicy) {
		this.customer = customer;
		this.screening = screening;
		this.fee = money;
		this.audienceCount = audienceCount;
		this.discountAgePolicy = discountAgePolicy;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Screening getScreening() {
		return screening;
	}
	
	public Money getFee() {
		return fee.minus(discountAgePolicy.calculateDiscountAmount(this));
	}
	
	public int getAudienceCount() {
		return audienceCount;
	}
}
