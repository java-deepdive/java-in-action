package kr.seok.baseball.v6.numbers;

import java.text.MessageFormat;
import java.util.Objects;

public class Ball {

	private static final String EXCEPTION_MESSAGES_VALID_RANGE_NUMBER = "1 ~ 9 사이의 숫자만 입력 가능합니다. : {}";
	private final int value;
	
	public Ball(int value) {
		checkArgument(value);
		this.value = value;
	}
	
	private void checkArgument(int value) {
		if(BallSize.outOfRange(value)) {
			throw new IllegalArgumentException(MessageFormat.format(EXCEPTION_MESSAGES_VALID_RANGE_NUMBER, value));
		}
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isMatches(Ball user) {
		return this.value == user.value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Ball ball)) return false;
		return value == ball.value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
	
	public enum BallSize {
		NUMBER_MIN_SIZE(1),
		NUMBER_MAX_SIZE(9);
		
		private final int value;
		
		BallSize(int value) {
			this.value = value;
		}
		
		public static boolean outOfRange(int value) {
			return value < NUMBER_MIN_SIZE.value || value > NUMBER_MAX_SIZE.value;
		}
		
		public int value() {
			return value;
		}
	}
}
