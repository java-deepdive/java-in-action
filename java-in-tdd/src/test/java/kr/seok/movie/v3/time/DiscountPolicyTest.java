package kr.seok.movie.v3.time;

import kr.seok.movie.v3.*;
import kr.seok.movie.v3.age.NoneDiscountAgePolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPolicyTest {
	
	private static Stream<Arguments> timeTable() {
		return Stream.of(
			// 조조 (00:00 ~ 09:30)
			Arguments.of(DayOfWeek.THURSDAY, LocalTime.of(0, 0), LocalTime.of(9, 30), LocalDateTime.of(2022, 10, 13, 9, 0), Money.wons(9000)),
			// 심야 (22:00 ~ 23:59)
			Arguments.of(DayOfWeek.THURSDAY, LocalTime.of(22, 0), LocalTime.of(23, 59), LocalDateTime.of(2022, 10, 13, 22, 0), Money.wons(9000)),
			Arguments.of(DayOfWeek.THURSDAY, LocalTime.of(22, 0), LocalTime.of(23, 59), LocalDateTime.of(2022, 10, 13, 23, 0), Money.wons(9000)),
			// 일반 (09:30 ~ 22:00)
			Arguments.of(DayOfWeek.THURSDAY, LocalTime.of(0, 0), LocalTime.of(9, 30), LocalDateTime.of(2022, 10, 13, 9, 31), Money.wons(10000)),
			Arguments.of(DayOfWeek.THURSDAY, LocalTime.of(22, 0), LocalTime.of(23, 59), LocalDateTime.of(2022, 10, 13, 21, 59), Money.wons(10000))
		);
	}
	
	@DisplayName("조조/야간/일반 할인 테스트")
	@MethodSource("timeTable")
	@ParameterizedTest(name = "{index} {displayName} {arguments}")
	void testCase1(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, LocalDateTime whenScreened, Money expected) {
		// given
		DiscountPolicy discountPolicy = new AmountDiscountPolicy(
			Money.wons(1000),
			// 주의해야 할 부분 선행 조건에서 적합한 경우 바로 할인이 적용됨
			new PeriodCondition(dayOfWeek, startTime, endTime)
		);
		
		Movie movie = new Movie("반지의 제왕", Money.wons(10000), discountPolicy);
		Screening screening = new Screening(movie, 1, whenScreened);
		
		// when
		Reservation reserve = screening.reserve(new Customer(20), 1, new NoneDiscountAgePolicy());
		Money fee = reserve.getFee();
		
		// then
		assertThat(fee).isEqualTo(expected);
	}
}