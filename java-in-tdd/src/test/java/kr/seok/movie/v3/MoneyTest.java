package kr.seok.movie.v3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
	
	@DisplayName("times 테스트")
	@Test
	void testCase1() {
		// given
		Money money = Money.wons(10000);
		
		// when
		Money result = money.times(1.5);
		
		// then
		assertEquals(Money.wons(15000), result);
	}
	
	@DisplayName("minus 테스트")
	@Test
	void testCase2() {
		// given
		Money money = Money.wons(10000);
		
		// when
		Money result = money.minus(Money.wons(10000));
		
		// then
		assertThat(result).isEqualTo(Money.wons(0));
	}
}