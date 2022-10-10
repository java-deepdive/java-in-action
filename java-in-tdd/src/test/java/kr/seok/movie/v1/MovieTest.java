package kr.seok.movie.v1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {
	
	@DisplayName("영화 가격 미할인 테스트")
	@Test
	void testCase1() {
		// given
		Movie movie = new Movie("스파이더맨", Money.wons(15000), new DiscountPolicy() {
			@Override
			public Money calculator() {
				return Money.ZERO;
			}
		});
		
		assertThat(movie.calculateMovieFee())
			.isEqualTo(Money.wons(15000));
	}
	
	@DisplayName("영화 가격 고정 할인 테스트")
	@Test
	void testCase2() {
		// given
		Movie movie = new Movie("스파이더맨", Money.wons(15000), new DiscountPolicy() {
			@Override
			public Money calculator() {
				return Money.wons(1000);
			}
		});
		
		assertThat(movie.calculateMovieFee()).isEqualTo(Money.wons(14000));
	}
	
	@DisplayName("영화 가격 비율 할인(10%) 테스트")
	@Test
	void testCase3() {
		// given
		Movie movie = new Movie("스파이더맨", Money.wons(15000), new DiscountPolicy() {
			@Override
			public Money calculator() {
				return Money.wons(15000).times(0.1);
			}
		});
		
		assertThat(movie.calculateMovieFee()).isEqualTo(Money.wons(13500));
	}
	
	@DisplayName("영화 가격 비율 할인(50%) 테스트")
	@Test
	void testCase4() {
		// given
		Movie movie = new Movie("스파이더맨", Money.wons(15000), new DiscountPolicy() {
			@Override
			public Money calculator() {
				return Money.wons(15000).times(0.5);
			}
		});
		
		assertThat(movie.calculateMovieFee()).isEqualTo(Money.wons(7500));
	}
}