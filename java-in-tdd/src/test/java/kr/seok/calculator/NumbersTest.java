package kr.seok.calculator;


import kr.seok.calculator.v1.Numbers;
import kr.seok.calculator.v1.pattern.CustomPattern;
import kr.seok.calculator.v1.pattern.DefaultPattern;
import kr.seok.calculator.v1.pattern.PatternSeparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumbersTest {

	private static Stream<Arguments> numberList() {
		return Stream.of(
				Arguments.of("1,2,3", new Integer[]{1, 2, 3}),
				Arguments.of("1,2:3", new Integer[]{1, 2, 3}),
				Arguments.of("1:2,3", new Integer[]{1, 2, 3})
		);
	}

	private static Stream<Arguments> customDelimiterList() {
		return Stream.of(
				Arguments.of("//;\n1;2;3", new Integer[]{1, 2, 3}),
				Arguments.of("//:\n5:6:7", new Integer[]{5, 6, 7})
		);
	}

	private static Stream<Arguments> strategySeparateNumbers() {
		return Stream.of(
				Arguments.of("1,2:3", new DefaultPattern(), new Integer[]{1, 2, 3}),
				Arguments.of("//;\n3;4;5", new CustomPattern(), new Integer[]{3, 4, 5}),
				Arguments.of("//#\n7#8#9", new CustomPattern(), new Integer[]{7, 8, 9})
		);
	}

	@DisplayName("일급 컬렉션 값 입력 테스트")
	@ParameterizedTest(name = "Numbers 객체에 구분자 값을 기준으로 split 되는지 테스트")
	@MethodSource(value = "numberList")
	void numbersOf(String given, Integer[] expected) {
		// given
		Numbers numbers = Numbers.of(given);
		// when
	}

	@DisplayName("일급 컬렉션 문자열 분리 테스트")
	@ParameterizedTest(name = "Numbers 객체에 사용자정의로 생성한 구분자 값을 기준으로 split 되는지 테스트")
	@MethodSource(value = "customDelimiterList")
	void numbersOf_getIntegers(String given, Integer[] expected) {
		// given
		Numbers numbers = Numbers.of(given);
		// when
	}

	@DisplayName("일급 컬렉션 전략에 따른 문자열 분리 테스트")
	@ParameterizedTest(name = "{0} 문자열을 {1} 전략에 따라 더하기")
	@MethodSource(value = "strategySeparateNumbers")
	void getExtractNumbers_전략에_따른_문자열분리(String given, PatternSeparator patternSeparator, Integer[] expected) {
		// given
	}
}
