package kr.seok.movie.v3;

import kr.seok.movie.v3.age.NoneDiscountAgePolicy;
import kr.seok.movie.v3.time.AmountDiscountPolicy;
import kr.seok.movie.v3.time.PeriodCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class ScreeningTest {
	
	@DisplayName("고정 금액 할인 테스트")
	@Test
	void testCase1() {
		// given
		Movie movie = new Movie("movie", Money.wons(10000),
			new AmountDiscountPolicy(Money.wons(800),
				new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
				new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
			)
		);
		LocalDateTime whenScreened = LocalDateTime.of(2020, 12, 14, 10, 0);
		Screening screening = new Screening(movie, 1, whenScreened);
		
		// when
		Reservation reserve = screening.reserve(new Customer(20), 1, new NoneDiscountAgePolicy());
		Money fee = reserve.getFee();
		
		// then
		assertThat(fee).isEqualTo(Money.wons(9200));
	}
}