package kr.seok.item7.memoryleek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoBoxingTest {
	
	@DisplayName("AutoBoxing 테스트")
	@Test
	void testCase1() {
		
		AutoBoxing autoBoxing = new AutoBoxing();
		long incremental = 0;
		for (long i = 0; i < 1_000_000; i++) {
			incremental = autoBoxing.addIncremental(i);
		}
		
		assertThat(incremental).isEqualTo(999_999);
	}
}