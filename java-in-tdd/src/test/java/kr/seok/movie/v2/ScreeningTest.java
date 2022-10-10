package kr.seok.movie.v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ScreeningTest {
	
	@DisplayName("상영 정보 생성 테스트")
	@Test
	void testCase1() {
		// given
		LocalDateTime whenScreened = LocalDateTime.of(2020, 1, 1, 10, 0);
		Movie movie = new Movie("스파이더맨", Money.wons(15000), () -> Money.ZERO);
		
		Screening screening = new Screening(movie, 1, whenScreened);
		Money movieFee = screening.getMovieFee();
		
		assertThat(movieFee).isEqualTo(Money.wons(15000));
	}
}