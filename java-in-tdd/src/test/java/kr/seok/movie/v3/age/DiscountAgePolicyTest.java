package kr.seok.movie.v3.age;

import kr.seok.movie.v3.*;
import kr.seok.movie.v3.time.NoneDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountAgePolicyTest {
	
	@DisplayName("Senior 할인 적용 테스트")
	@Test
	void testCase1() {
		// given
		Movie movie = new Movie("test", Money.wons(10000), new NoneDiscountPolicy());
		DiscountAgePolicy policy = new PercentDiscountAgePolicy(0.5, new SeniorCondition());
		
		// when
		Screening screening = new Screening(movie, 1, LocalDateTime.now());
		Reservation reserve = screening.reserve(new Customer(65), 1, policy);
		
		Money fee = reserve.getFee();
		
		// then
		assertThat(fee).isEqualTo(Money.wons(5000));
	}
	
	@DisplayName("Teenager 할인 적용 테스트")
	@Test
	void testCase2() {
		// given
		Movie movie = new Movie("test", Money.wons(10000), new NoneDiscountPolicy());
		DiscountAgePolicy policy = new PercentDiscountAgePolicy(0.2, new TeenagerCondition());
		
		// when
		Screening screening = new Screening(movie, 1, LocalDateTime.now());
		Reservation reserve = screening.reserve(new Customer(13), 1, policy);
		
		Money fee = reserve.getFee();
		
		// then
		assertThat(fee).isEqualTo(Money.wons(8000));
	}
	
	@DisplayName("일반인 할인 적용 테스트")
	@Test
	void testCase3() {
		// given
		Movie movie = new Movie("test", Money.wons(10000), new NoneDiscountPolicy());
		DiscountAgePolicy policy = new NoneDiscountAgePolicy();
		
		// when
		Screening screening = new Screening(movie, 1, LocalDateTime.now());
		Reservation reserve = screening.reserve(new Customer(20), 1, policy);
		
		Money fee = reserve.getFee();
		
		// then
		assertThat(fee).isEqualTo(Money.wons(10000));
	}
}