package kr.seok.item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static kr.seok.item6.Sum.primitiveSum;
import static kr.seok.item6.Sum.sum;

@DisplayName("아이템 6. 불필요한 객체 생성을 피하라")
class SumTest {
	
	@DisplayName("오토박싱을 통한 불필요한 객체 생성")
	@Test
	void testCase1() {
		int numSets = 5;
		long x = 0;
		
		for (int i = 0; i < numSets; i++) {
			long start = System.nanoTime();
			x += sum();
			long end = System.nanoTime();
			System.out.println((end - start) / 1_000_000. + " ms.");
		}
		
		// Prevents VM from optimizing away everything.
		if (x == 42)
			System.out.println();
	}
	
	@DisplayName("primitive 기본 타입 합산 연산")
	@Test
	void testCase2() {
		int numSets = 5;
		long x = 0;
		
		for (int i = 0; i < numSets; i++) {
			long start = System.nanoTime();
			x += primitiveSum();
			long end = System.nanoTime();
			System.out.println((end - start) / 1_000_000. + " ms.");
		}
		
		// Prevents VM from optimizing away everything.
		if (x == 42)
			System.out.println();
	}
}