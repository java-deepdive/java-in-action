package kr.seok.item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static kr.seok.item6.RomanNumerals.isRomanNumeralFast;
import static kr.seok.item6.RomanNumerals.isRomanNumeralSlow;

@DisplayName("아이템 6. 불필요한 객체 생성을 피하라")
class RomanNumeralsTest {
	private static Stream<Arguments> romanNumbers() {
		return Stream.of(
			Arguments.of("MCMLXXVI")
			, Arguments.of("MCMXC")
			, Arguments.of("MMXIV")
			, Arguments.of("MDCLXVI")
			, Arguments.of("MCMXCVI")
			, Arguments.of("MCMXCVII")
			, Arguments.of("MCMXCVIII")
			, Arguments.of("MCMXCIX")
			, Arguments.of("MM")
			, Arguments.of("MMMCMXCIX")
		
		);
	}
	
	@DisplayName("ROMAN NUMERAL Slow TEST")
	@MethodSource("romanNumbers")
	@ParameterizedTest(name = "ROMAN NUMERAL Slow TEST: {index} => romanNumber={0}")
	void testCase1(String romanNumber) {
		
		int numSets = 50;
		int numReps = 50;
		
		boolean b = false;
		
		for (int i = 0; i < numSets; i++) {
			long start = System.nanoTime();
			for (int j = 0; j < numReps; j++) {
				b ^= isRomanNumeralSlow(romanNumber);  // Change Slow to Fast to see performance difference
			}
			long end = System.nanoTime();
			System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
		}
		
		// Prevents VM from optimizing away everything.
		if (!b)
			System.out.println();
	}
	
	@DisplayName("ROMAN NUMERAL Fast TEST")
	@MethodSource("romanNumbers")
	@ParameterizedTest(name = "ROMAN NUMERAL Fast TEST: {index} => romanNumber={0}")
	void testCase2(String romanNumber) {
		int numSets = 50;
		int numReps = 50;
		
		boolean b = false;
		
		for (int i = 0; i < numSets; i++) {
			long start = System.nanoTime();
			for (int j = 0; j < numReps; j++) {
				b ^= isRomanNumeralFast(romanNumber);  // Change Slow to Fast to see performance difference
			}
			long end = System.nanoTime();
			System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
		}
		
		// Prevents VM from optimizing away everything.
		if (!b)
			System.out.println();
	}
}