package kr.seok.java8.chicken.v9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class PrimeTestTest {
	
	@DisplayName("소수 판별 테스트")
	@Test
	void testCase1() {
		// given
		int skip = 0;
		int limit = 100;
		// when
		IntStream.iterate(1, n -> n + 1)
			.skip(skip)
			.limit(limit)
			.filter(Prime::isPrime)
			.forEach(System.out::println);
		// then
	}
}