package kr.seok.calculator.v1.pattern;


import kr.seok.calculator.v1.exception.CalculatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomPattern implements PatternSeparator {

	public static final String NOT_FOUND_PATTERN = "패턴을 찾을 수 없습니다.";
	public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
	public static final int CUSTOM_DELIMITER_POSITION = 1;
	public static final int NUMBERS_GROUP_POSITION = 2;

	@Override
	public String[] matches(String text) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
		if (!matcher.find()) {
			throw new CalculatorException(NOT_FOUND_PATTERN);
		}
		String customDelimiter = matcher.group(CUSTOM_DELIMITER_POSITION);
		String tokens = matcher.group(NUMBERS_GROUP_POSITION);

		return tokens.split(customDelimiter);
	}

}
