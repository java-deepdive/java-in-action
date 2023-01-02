package kr.seok.baseball.v6.numbers;

import java.text.MessageFormat;

public class Ball {
	public static final int NUMBER_MIN_SIZE = 1;
	public static final int NUMBER_MAX_SIZE = 9;
	public static final String EXCEPTION_MESSAGES_VALID_RANGE_NUMBER = "1 ~ 9 사이의 숫자만 입력 가능합니다. : {}";
	private final int value;
	
	public Ball(int value) {
		checkArgument(value);
		this.value = value;
	}
	
	private void checkArgument(int value) {
		if(value < NUMBER_MIN_SIZE || value > NUMBER_MAX_SIZE) {
			throw new IllegalArgumentException(MessageFormat.format(EXCEPTION_MESSAGES_VALID_RANGE_NUMBER, value));
		}
	}
	
	public int getValue() {
		return value;
	}
}
