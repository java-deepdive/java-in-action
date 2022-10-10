package kr.seok.movie.v2;


public class Reservation {
	private Customer customer;
	private Screening screening;
	private Money fee;
	private int audienceCount;
	
	public Reservation(Customer customer, Screening screening, Money money, int audienceCount) {
		this.customer = customer;
		this.screening = screening;
		this.fee = money;
		this.audienceCount = audienceCount;
	}
}
