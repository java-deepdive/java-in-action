package kr.seok.baseball.v2;

import java.util.Objects;

import static kr.seok.baseball.v2.Ball.BallRule.MAX;
import static kr.seok.baseball.v2.Ball.BallRule.MIN;

public class Ball {
	private final int value;
	
	public Ball(String value) {
		this(Integer.parseInt(value));
	}
	
	public Ball(int value) {
		checkArgument(value);
		this.value = value;
	}
	
	public boolean isMatches(Ball ball) {
		return this.value == ball.value;
	}
	
	private void checkArgument(int value) {
		if (!isRange(value)) {
			throw new RuntimeException("1 ~ 9 범위에서 벗어났습니다.");
		}
	}
	
	private boolean isRange(int value) {
		return value >= MIN.value && value <= MAX.value;
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
