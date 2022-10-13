package kr.seok.movie.v3.time;

import kr.seok.movie.v3.Screening;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountConditionTest {
	
	@DisplayName("조조 할인 테스트")
	@Test
	void testCase1() {
		// given
		DiscountCondition condition = new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(0, 0), LocalTime.of(9, 30));
		LocalDateTime whenScreened = LocalDateTime.of(2022, 10, 13, 9, 0);
		// when
		boolean isSatisfiedBy = condition.isSatisfiedBy(new Screening(null, 1, whenScreened));
		// then
		assertThat(isSatisfiedBy).isTrue();
	}
	
	@DisplayName("심야 할인 테스트")
	@Test
	void testCase2() {
		// given
		DiscountCondition condition = new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(22, 0), LocalTime.of(23, 59));
		LocalDateTime whenScreened = LocalDateTime.of(2022, 10, 13, 22, 0);
		// when
		boolean isSatisfiedBy = condition.isSatisfiedBy(new Screening(null, 1, whenScreened));
		// then
		assertThat(isSatisfiedBy).isTrue();
	}
	
	@DisplayName("일반 할인 테스트")
	@Test
	void testCase3() {
		// given
		DiscountCondition condition = new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(0, 0), LocalTime.of(9, 30));
		LocalDateTime whenScreened = LocalDateTime.of(2022, 10, 13, 13, 50);
		// when
		boolean isSatisfiedBy = condition.isSatisfiedBy(new Screening(null, 1, whenScreened));
		// then
		assertThat(isSatisfiedBy).isFalse();
	}
	
	@DisplayName("일반 할인 테스트")
	@Test
	void testCase4() {
		// given
		DiscountCondition condition = new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(22, 0), LocalTime.of(23, 59));
		LocalDateTime whenScreened = LocalDateTime.of(2022, 10, 13, 13, 50);
		// when
		boolean isSatisfiedBy = condition.isSatisfiedBy(new Screening(null, 1, whenScreened));
		// then
		assertThat(isSatisfiedBy).isFalse();
	}
}