package kr.seok.movie.v2;

import kr.seok.movie.v3.time.PercentDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
	
	@DisplayName("상영 정보 생성 및 비율 할인 검증 테스트")
	@Test
	void testCase4() {
		// given
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		LocalTime startTime = LocalTime.of(0, 0);
		LocalTime endTime = LocalTime.of(9, 30);
		DiscountCondition periodCondition = new PeriodCondition(dayOfWeek, startTime, endTime);
		DiscountPolicy percentDiscountPolicy = new PercentDefaultDiscountPolicy(0.5, periodCondition);
		
		LocalDateTime whenScreened = LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 30));
		
		Movie movie = new Movie("어벤져스", Money.wons(10000), percentDiscountPolicy);
		// when
		Screening screening = new Screening(movie, 1, whenScreened);
		Reservation reserve = screening.reserve(null, 1);
		Money fee = reserve.getFee();
		
		// then
		assertThat(fee).isEqualTo(Money.wons(5000));
	}
}