package kr.seok.baseball.v3.vo;

import java.util.Objects;

public class Ball {
	private final int value;
	
	public Ball(int value) {
		checkArgument(value, "숫자는 1에서 9 사이여야 합니다.");
		this.value = value;
	}
	
	private void checkArgument(int value, String messages) {
		if (!(value >= BallRule.MIN.value() && value <= BallRule.MAX.value())) {
			throw new IllegalArgumentException(messages);
		}
	}
	
	public int value() {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Ball)) return false;
		Ball ball = (Ball) o;
		return value == ball.value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
	
	@Override
	public String toString() {
		return "Ball{" +
			"value=" + value +
			'}';
	}
	
	enum BallRule {
		MIN(1),
		MAX(9);
		
		private final int value;
		
		BallRule(int value) {
			this.value = value;
		}
		
		public int value() {
			return value;
		}
	}
}
