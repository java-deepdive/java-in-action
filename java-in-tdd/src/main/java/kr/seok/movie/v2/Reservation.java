package kr.seok.movie.v2;


public class Reservation {
	private final Customer customer;
	private final Screening screening;
	private final Money fee;
	private final int audienceCount;
	
	public Reservation(Customer customer, Screening screening, Money money, int audienceCount) {
		this.customer = customer;
		this.screening = screening;
		this.fee = money;
		this.audienceCount = audienceCount;
	}
	
	public Money getFee() {
		return fee;
	}
}
