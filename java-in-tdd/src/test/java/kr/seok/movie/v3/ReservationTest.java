package kr.seok.movie.v3;

import kr.seok.movie.v3.age.DiscountAgePolicy;
import kr.seok.movie.v3.age.NoneDiscountAgePolicy;
import kr.seok.movie.v3.time.AmountDiscountPolicy;
import kr.seok.movie.v3.time.DiscountPolicy;
import kr.seok.movie.v3.time.PeriodCondition;
import kr.seok.movie.v3.time.SequenceCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class ReservationTest {
	
	@DisplayName("영화 예매 고정 금액 할인 테스트")
	@Test
	void testCase1() {
		DiscountPolicy discountPolicy = new AmountDiscountPolicy(
			Money.wons(5000),
			new SequenceCondition(1),
			new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(12, 0), LocalTime.of(23, 59))
		);
		Movie movie = new Movie("반지의 제왕", Money.wons(10000), discountPolicy);
		
		Screening screening = new Screening(movie, 1, LocalDateTime.now());
		Reservation reserve = screening.reserve(new Customer(20), 1, new NoneDiscountAgePolicy());
		Money fee = reserve.getFee();
		
		assertThat(fee).isEqualTo(Money.wons(5000));
	}
	
	@DisplayName("영화 예매 비율 할인 테스트")
	@Test
	void testCase2() {
		DiscountPolicy discountPolicy = new AmountDiscountPolicy(
			Money.wons(5000),
			new SequenceCondition(1),
			new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(12, 0), LocalTime.of(23, 59))
		);
		Movie movie = new Movie("반지의 제왕", Money.wons(10000), discountPolicy);
		
		Screening screening = new Screening(movie, 1, LocalDateTime.now());
		Reservation reserve = screening.reserve(new Customer(20), 1, new NoneDiscountAgePolicy());
		Money fee = reserve.getFee();
		
		assertThat(fee).isEqualTo(Money.wons(5000));
	}
}