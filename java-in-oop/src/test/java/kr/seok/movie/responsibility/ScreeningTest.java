package kr.seok.movie.responsibility;

import kr.seok.movie.responsibility.policy.NoneDefaultDiscountPolicy;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningTest {
	
	@Test
	void testCase1() {
		// given
		LocalDateTime whenScreened = LocalDateTime.of(2020, 1, 1, 10, 0);
		Movie movie = new Movie("스파이더맨", Duration.ofMinutes(120), Money.wons(10000), new NoneDefaultDiscountPolicy());
		
		Screening screening = new Screening(movie, 1, whenScreened);
		
	}
}