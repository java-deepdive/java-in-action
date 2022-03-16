package kr.seok.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/**
 * 온라인 코드리뷰 요청 1단계 <br/>
 * - String 클래스에 대한 학습 테스트 <br/>
 * - JUnit Assertions 클래스의 테스트 API 학습 <br/>
 * - 예외 발생시 Throw 테스트 처리 학습 <br/>
 * - DisplayName 어노테이션 학습
 */
public class StringTest {

	private static final String SPLIT_DELIMITER = ",";

	@Test
	@DisplayName("요구사항 1: `1,2`을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
	void splitStringArrays() {
		String[] given = "1,2".split(SPLIT_DELIMITER);
		assertThat(given).contains("1", "2");
		assertThat(given).containsExactly("1", "2");
	}

	@Test
	@DisplayName("요구사항 1: `1`을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
	void containsStringValue() {
		String[] given = "1".split(SPLIT_DELIMITER);

		assertThat(given).contains("1");
		assertThat(given).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항 2: `(1,2)` 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 `1,2`를 반환하도록 구현한다.")
	void subStringValue() {
		String given = "(1,2)";
		String removeBracket = given.substring(1, given.length() - 1);

		assertThat(removeBracket).isEqualTo("1,2");
	}

	@ParameterizedTest(name = "인덱스 {0} 값은 {1}를 반환")
	@CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
	@DisplayName("요구사항 3: `abc` 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
	void getStringCharAt(int index, Character expected) {
		String given = "abc";

		assertThat(given.charAt(index)).isEqualTo(expected);
	}

	@Test
	@DisplayName("요구사항 3: String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
	void stringCharAtExceptionTest() {
		String given = "abc";

		assertThatThrownBy(() -> {
			given.charAt(given.length());
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: " + given.length());
	}

	@Test
	@DisplayName("요구사항 3: 위 테스트와 동일하나 JUnit 예외테스트 코드만 변경 테스트")
	void stringCharAtExceptionTest2() {
		String given = "abc";

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
				.isThrownBy(() -> {
					given.charAt(given.length());

				}).withMessageMatching("String index out of range: " + given.length());
	}
}
