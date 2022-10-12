package kr.seok.movie.v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountConditionTest {
	
	@DisplayName("조조 할인 조건 테스트")
	@Test
	void testCase1() {
		DiscountCondition discountCondition = new PeriodCondition(
			DayOfWeek.TUESDAY,
			LocalTime.of(0, 0),
			LocalTime.of(9, 30)
		);
		LocalDateTime of = LocalDateTime.now();
		boolean satisfiedBy = discountCondition.isSatisfiedBy(new Screening(null, 1, of));
		assertThat(satisfiedBy).isFalse();
	}
	
	@DisplayName("심야 할인 조건 테스트")
	@Test
	void testCase2() {
		DiscountCondition discountCondition = new PeriodCondition(
			DayOfWeek.TUESDAY,
			LocalTime.of(22, 0),
			LocalTime.of(23, 59)
		);
		// 현재 시간
		LocalDateTime of = LocalDateTime.of(2022, 10, 11, 22, 30);
		boolean satisfiedBy = discountCondition.isSatisfiedBy(new Screening(null, 1, of));
		assertThat(satisfiedBy).isTrue();
	}
}