package kr.seok.racing.step2;

import java.util.Objects;
import java.util.regex.Pattern;

import static kr.seok.racing.step2.Constants.REGEXP;
import static kr.seok.racing.step2.Constants.ZERO;

/**
 * 유효성 검사를 위한 클래스
 */
public final class Validator {

	private Validator() {
	}

	public static boolean isBlank(String input) {
		return Objects.isNull(input) || input.trim().isEmpty();
	}

	public static boolean isNumeric(String item) {
		try {
			Integer.parseInt(item);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void isDivideByZero(Integer a) {
		if (a.equals(ZERO)) {
			throw new IllegalArgumentException("divide 연산이 불가합니다.");
		}
	}

	public static boolean isValidation(String input) {
		return Pattern.matches(REGEXP, input);
	}
}
