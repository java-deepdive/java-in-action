package kr.seok.calculator;

import kr.seok.calculator.v1.Number;
import kr.seok.calculator.v1.exception.CalculatorException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
	
	private static Stream<Arguments> numberEntry() {
		return Stream.of(
			Arguments.of("1", 1),
			Arguments.of("5", 5)
		);
	}
	
	@ParameterizedTest(name = "Number 객체 값 입력 비교 {0} == {1}")
	@MethodSource(value = "numberEntry")
	void numberOf_데이터타입_객체값_비교(String given, int givenNumber) {
		// given
		Number number = Number.of(given);
		// when
		Number expected = Number.of(givenNumber);
		// then
		assertThat(number).isEqualTo(expected);
	}
	
	@ParameterizedTest(name = "{0} 입력 값 예외처리")
	@CsvSource(value = {"-1"})
	void numberOf_음수값_예외처리(String given) {
		assertThatThrownBy(() -> Number.of(given))
			.isInstanceOf(CalculatorException.class);
		
	}
}
