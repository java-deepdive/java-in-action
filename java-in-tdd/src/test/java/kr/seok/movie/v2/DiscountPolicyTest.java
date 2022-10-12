package kr.seok.movie.v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPolicyTest {
	
	@DisplayName("할인 정책 미적용 테스트")
	@Test
	void testCase1() {
		// given
		DiscountPolicy discountPolicy = new NoneDefaultDiscountPolicy();
		Movie movie = new Movie("스파이더맨", Money.wons(15000), discountPolicy);
		Screening screening = new Screening(movie, 1, LocalDateTime.of(2020, 1, 1, 10, 0));
		
		// when
		Reservation reserve = screening.reserve(new Customer(20), 1);
		// then
		assertThat(reserve.getFee()).isEqualTo(Money.wons(15000));
	}
	
	@DisplayName("고정 할인 정책 적용 테스트")
	@Test
	void testCase2() {
		// given
		Movie movie = new Movie("스파이더맨", Money.wons(15000),
			new AmountDefaultDiscountPolicy(Money.wons(1000), new SequenceCondition(1))
		);
		Screening screening = new Screening(movie, 1, LocalDateTime.of(2020, 1, 1, 10, 0));
		
		// when
		Reservation reserve = screening.reserve(new Customer(20), 1);
		// then
		assertThat(reserve.getFee()).isEqualTo(Money.wons(14000));
	}
	
	@DisplayName("비율 할인 정책 적용 테스트")
	@Test
	void testCase3() {
		// given
		Movie movie = new Movie("스파이더맨", Money.wons(15000),
			new PercentDefaultDiscountPolicy(0.5,
				// 기간 할인 조건
				new PeriodCondition(
					DayOfWeek.MONDAY,
					LocalTime.of(23, 0),
					LocalTime.of(23, 59)
				))
		);
		// 영화 예매 시간 (당일, 현시간 인 경우)
		Screening screening = new Screening(movie, 1, LocalDateTime.of(2022, 10, 10, 23, 30));
		
		// when
		Reservation reserve = screening.reserve(new Customer(20), 1);
		// then
		assertThat(reserve.getFee()).isEqualTo(Money.wons(7500));
	}
}