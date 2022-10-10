package kr.seok.movie.v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ScreeningTest {
	
	@DisplayName("상영 정보 생성 테스트")
	@Test
	void testCase1() {
		// given
		LocalDateTime whenScreened = LocalDateTime.of(2020, 1, 1, 10, 0);
		Movie movie = new Movie("스파이더맨", Money.wons(15000), (Screening screening) -> Money.ZERO);
		
		Screening screening = new Screening(movie, 1, whenScreened);
		Money movieFee = screening.getMovieFee();
		
		assertAll(
			() -> assertThat(movieFee).isEqualTo(Money.wons(15000)),
			() -> assertThat(screening.isSequence(1)).isTrue(),
			() -> assertThat(screening.getStartTime()).isEqualTo(whenScreened)
		);
	}
	
	@DisplayName("영화 예매 테스트")
	@Test
	void testCase2() {
		// given
		LocalDateTime whenScreened = LocalDateTime.of(2020, 1, 1, 10, 0);
		Movie movie = new Movie("스파이더맨", Money.wons(15000), (Screening screening) -> Money.ZERO);
		
		Screening screening = new Screening(movie, 1, whenScreened);
		Reservation reservation = screening.reserve(new Customer(20), 2);
		Money receipt = reservation.getFee();
		
		assertThat(receipt).isEqualTo(Money.wons(30000));
	}
	
	@DisplayName("영화 예매 퍼센트 할인 테스트")
	@Test
	void testCase3() {
		// given
		LocalDateTime whenScreened = LocalDateTime.of(2020, 1, 1, 10, 0);
		Movie movie = new Movie("스파이더맨", Money.wons(15000), new DiscountPolicy() {
			@Override
			public Money calculateDiscountAmount(Screening screening) {
				return Money.wons(1000);
			}
		});
		
		Screening screening = new Screening(movie, 1, whenScreened);
		Reservation reservation = screening.reserve(new Customer(20), 2);
		Money receipt = reservation.getFee();
		
		assertThat(receipt).isEqualTo(Money.wons(29000));
	}
}