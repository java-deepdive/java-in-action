package kr.seok.baseball.assertion;

public class Ball {
	
	private final String RANGE_EXCEPTION = "숫자 범위안에 있지 않습니다";
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private final int number;
	
	public Ball(int number) {
		validation(number);
		this.number = number;
	}
	
	private void validation(int number) {
		validateRange(number);
	}
	
	private void validateRange(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException(RANGE_EXCEPTION);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.number == ((Ball) obj).number) {
			return true;
		}
		return false;
	}
}
