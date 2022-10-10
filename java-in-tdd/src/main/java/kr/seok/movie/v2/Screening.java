package kr.seok.movie.v2;

import java.time.LocalDateTime;

public class Screening {
	// 상영할 영화
	private final Movie movie;
	// 상영 순번
	private final int sequence;
	// 상영 시작 시간
	private final LocalDateTime whenScreened;
	
	public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
		this.movie = movie;
		this.sequence = sequence;
		this.whenScreened = whenScreened;
	}
	
	public LocalDateTime getStartTime() {
		return whenScreened;
	}
	
	public boolean isSequence(int sequence) {
		return this.sequence == sequence;
	}
	
	public Money getMovieFee() {
		return movie.getFee();
	}
	
	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
	}
	
	private Money calculateFee(int audienceCount) {
		return movie.calculateMovieFee(this).times(audienceCount);
	}
}
